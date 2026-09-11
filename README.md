# data-center-ops

Data Center operations actor scaffold.

## DID

- `did:web:data-center-ops.etzhayyim.com`

## Manifest

- `20-actors/data-center-ops/actor-manifest.jsonld`

## Lexicons

- `com.etzhayyim.apps.dataCenterOps.infrastructure.getFacility`
- `com.etzhayyim.apps.dataCenterOps.infrastructure.listFacilities`
- `com.etzhayyim.apps.dataCenterOps.infrastructure.listRacks`
- `com.etzhayyim.apps.dataCenterOps.infrastructure.getPowerZones`
- `com.etzhayyim.apps.dataCenterOps.infrastructure.getSlaSummary`
- `com.etzhayyim.apps.dataCenterOps.dependency.seedBaseline`
- `com.etzhayyim.apps.dataCenterOps.dependency.collectGlobal`
- `com.etzhayyim.apps.dataCenterOps.dependency.listNodes`
- `com.etzhayyim.apps.dataCenterOps.dependency.listEdges`
- `com.etzhayyim.apps.dataCenterOps.dependency.getReverseTopo`
- `com.etzhayyim.apps.dataCenterOps.health`
- `com.etzhayyim.apps.dataCenterOps.coverage.get`

Lexicon files are under `00-contracts/lexicons/com/etzhayyim/apps/dataCenterOps/`.

## BPMN

- `etzhayyim-root/60-apps/etzhayyim-project-auto-sales-erp/bpmn/data-center-ops-operations.bpmn`
- `etzhayyim-root/60-apps/etzhayyim-project-auto-sales-erp/bpmn/data-center-ops-dependency-reverse-topo.bpmn`

Process outline:
- operations: telemetry collection -> reverse dependency topology -> capacity evaluation -> SLA check -> (risk? incident escalation : dashboard update)
- dependency: seed baseline -> list nodes -> list edges -> collect global -> reverse topo resolve

Dependency baseline includes:
- land
- facility
- permit/approval
- ISCO workforce
- APQC operations framework
- power
- rack
- server
- license/compliance

## MCP

MCP tool exposure is driven by T1 manifest XRPC triggers and actor capability registration.
The above XRPC NSIDs are intended MCP-callable surfaces for Data Center Ops reads/health/coverage.

## RisingWave Schema

Physical graph schema is defined by migration:

- `30-graph/graph-schema/migrations/20260416124000_data_center_ops_dependency_graph.ts`

Objects created:

- vertex table: `vertex_data_center_dependency`
- vertex table (global): `vertex_data_center_dependency_global`
- edge table: `edge_data_center_dependency`
- edge table (global): `edge_data_center_dependency_global`
- materialized views:
  - `mv_data_center_dependency_reverse_topology`
  - `mv_data_center_dependency_domain_summary`
  - `mv_data_center_dependency_global_actor`
  - `mv_data_center_dependency_global_edge`

Baseline seed rows include:

- `dc-operations`
- `apqc-operations-framework`
- `isco-workforce`
- `sla-governance`
- `license-compliance`
- `server-fleet`
- `rack-capacity`
- `power-grid`
- `facility-site`
- `permit-approval`
- `land-plot`

## Actor boundary

`src/data_center_ops/murakumo.cljk` is the only executable code here. It turns a
request into `:mst/put-record` effects, and nothing downstream re-derives them,
so what it refuses and what it drops both matter.

`cell-plan` emits **no effects at all** until every gate in `common-gates` has
attested. Attestations may be a map or a set, keyed by keyword or by string; a
gate answered `false`, or absent, or an absent attestation collection, all read
as "not attested". Gates are checked before the payload is looked at.

Two things are refused rather than accepted quietly, because in both cases the
plan that would otherwise be produced is a well-formed instruction the host
would execute and report as a success:

- **`records` in a shape carrying no usable index** — a map (by collection name
  or by position) and a sequential collection are read; anything else raises
  `:records/unusable-shape` instead of yielding a record with no payload in it.
- **A record restating the actor's own provenance differently** — `$type`,
  `actorDid`, `legacyCell`, `phase`, `actorBoundary`, `scaffold` and
  `constitutionalStatus` are what a later reader uses to learn who wrote a
  record and under which regime. A caller may repeat them verbatim, so records
  round-trip, but changing one raises `:record/forged-provenance` naming the
  field.

## Tests

    nbb test/data_center_ops/murakumo_test.cljk

No JVM. The source is `.cljc` with no reader conditionals, so this one runtime
executes all of it. The mutation battery that checks these tests still bite
lives in the superproject at `scripts/maturity-loop/mutations.edn`.

`actor-manifest.test.ts` predates this and does not run: there is no
`package.json` and no vitest here.

## Known identity divergence

`actor-did` and `actor-manifest.jsonld` both say
`did:web:data-center-ops.etzhayyim.com`. `.well-known/did.json` says
`did:web:etzhayyim.com:actor:data-center-ops` — a different DID, from the
identity migration in `3968d35`, which the manifest and the actor boundary were
never moved onto. The tests pin the two that agree; they do not assert the
divergence away. Changing `actor-did` changes every record key and every effect
this actor emits, so it is a decision for whoever owns the identity, not a
side effect of a test.
