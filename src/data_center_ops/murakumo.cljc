(ns data_center_ops.murakumo
  "Pure cljc actor boundary generated from manifest migration scaffold."
  (:require [clojure.string :as str]))

(def actor-did
  "did:web:data-center-ops.etzhayyim.com")

(def common-gates
  [:council-charter-attestation
   :no-platform-held-key-baseline
   :no-probing-baseline
   :murakumo-only-inference-baseline
   :did-primary-baseline
   :append-only-gate-baseline
   :kotoba-only-substrate-baseline])

(defn collection
  [name]
  (str "com.etzhayyim.data-center-ops." name))

(def cell-specs {
  :getfacility {:legacy-cell "com-etzhayyim-apps-dataCenterOps-infrastructure-getFacility"
     :phase :event
     :murakumo-node "reuben"
     :collections [(collection "getfacility")]
     :required-gates common-gates
     :trigger "manifest cell getfacility"
     :ceiling "Manifest-driven migration scaffold; explicit execution stays in runtime methods"}
  :listfacilities {:legacy-cell "com-etzhayyim-apps-dataCenterOps-infrastructure-listFacilities"
     :phase :event
     :murakumo-node "reuben"
     :collections [(collection "listfacilities")]
     :required-gates common-gates
     :trigger "manifest cell listfacilities"
     :ceiling "Manifest-driven migration scaffold; explicit execution stays in runtime methods"}
  :listracks {:legacy-cell "com-etzhayyim-apps-dataCenterOps-infrastructure-listRacks"
     :phase :event
     :murakumo-node "reuben"
     :collections [(collection "listracks")]
     :required-gates common-gates
     :trigger "manifest cell listracks"
     :ceiling "Manifest-driven migration scaffold; explicit execution stays in runtime methods"}
  :getpowerzones {:legacy-cell "com-etzhayyim-apps-dataCenterOps-infrastructure-getPowerZones"
     :phase :event
     :murakumo-node "reuben"
     :collections [(collection "getpowerzones")]
     :required-gates common-gates
     :trigger "manifest cell getpowerzones"
     :ceiling "Manifest-driven migration scaffold; explicit execution stays in runtime methods"}
  :getslasummary {:legacy-cell "com-etzhayyim-apps-dataCenterOps-infrastructure-getSlaSummary"
     :phase :event
     :murakumo-node "reuben"
     :collections [(collection "getslasummary")]
     :required-gates common-gates
     :trigger "manifest cell getslasummary"
     :ceiling "Manifest-driven migration scaffold; explicit execution stays in runtime methods"}
  :seedbaseline {:legacy-cell "com-etzhayyim-apps-dataCenterOps-dependency-seedBaseline"
     :phase :event
     :murakumo-node "reuben"
     :collections [(collection "seedbaseline")]
     :required-gates common-gates
     :trigger "manifest cell seedbaseline"
     :ceiling "Manifest-driven migration scaffold; explicit execution stays in runtime methods"}
  :listnodes {:legacy-cell "com-etzhayyim-apps-dataCenterOps-dependency-listNodes"
     :phase :event
     :murakumo-node "reuben"
     :collections [(collection "listnodes")]
     :required-gates common-gates
     :trigger "manifest cell listnodes"
     :ceiling "Manifest-driven migration scaffold; explicit execution stays in runtime methods"}
  :listedges {:legacy-cell "com-etzhayyim-apps-dataCenterOps-dependency-listEdges"
     :phase :event
     :murakumo-node "reuben"
     :collections [(collection "listedges")]
     :required-gates common-gates
     :trigger "manifest cell listedges"
     :ceiling "Manifest-driven migration scaffold; explicit execution stays in runtime methods"}
  :collectglobal {:legacy-cell "com-etzhayyim-apps-dataCenterOps-dependency-collectGlobal"
     :phase :event
     :murakumo-node "reuben"
     :collections [(collection "collectglobal")]
     :required-gates common-gates
     :trigger "manifest cell collectglobal"
     :ceiling "Manifest-driven migration scaffold; explicit execution stays in runtime methods"}
  :getreversetopo {:legacy-cell "com-etzhayyim-apps-dataCenterOps-dependency-getReverseTopo"
     :phase :event
     :murakumo-node "reuben"
     :collections [(collection "getreversetopo")]
     :required-gates common-gates
     :trigger "manifest cell getreversetopo"
     :ceiling "Manifest-driven migration scaffold; explicit execution stays in runtime methods"}
  :health {:legacy-cell "com-etzhayyim-apps-dataCenterOps-health"
     :phase :event
     :murakumo-node "reuben"
     :collections [(collection "health")]
     :required-gates common-gates
     :trigger "manifest cell health"
     :ceiling "Manifest-driven migration scaffold; explicit execution stays in runtime methods"}
  :get {:legacy-cell "com-etzhayyim-apps-dataCenterOps-coverage-get"
     :phase :event
     :murakumo-node "reuben"
     :collections [(collection "get")]
     :required-gates common-gates
     :trigger "manifest cell get"
     :ceiling "Manifest-driven migration scaffold; explicit execution stays in runtime methods"}
  :shinkaevolution {:legacy-cell "com-etzhayyim-apps-standard-shinkaEvolution"
     :phase :event
     :murakumo-node "reuben"
     :collections [(collection "shinkaevolution")]
     :required-gates common-gates
     :trigger "manifest cell shinkaevolution"
     :ceiling "Manifest-driven migration scaffold; explicit execution stays in runtime methods"}
  :shinkaknowledge {:legacy-cell "com-etzhayyim-apps-standard-shinkaKnowledge"
     :phase :event
     :murakumo-node "reuben"
     :collections [(collection "shinkaknowledge")]
     :required-gates common-gates
     :trigger "manifest cell shinkaknowledge"
     :ceiling "Manifest-driven migration scaffold; explicit execution stays in runtime methods"}
  :shinka {:legacy-cell "shinka"
     :phase :event
     :murakumo-node "reuben"
     :collections [(collection "shinka")]
     :required-gates common-gates
     :trigger "manifest cell shinka"
     :ceiling "Manifest-driven migration scaffold; explicit execution stays in runtime methods"}
  :koji {:legacy-cell "koji"
     :phase :event
     :murakumo-node "reuben"
     :collections [(collection "koji")]
     :required-gates common-gates
     :trigger "manifest cell koji"
     :ceiling "Manifest-driven migration scaffold; explicit execution stays in runtime methods"}
  :kyumei {:legacy-cell "kyumei"
     :phase :event
     :murakumo-node "reuben"
     :collections [(collection "kyumei")]
     :required-gates common-gates
     :trigger "manifest cell kyumei"
     :ceiling "Manifest-driven migration scaffold; explicit execution stays in runtime methods"}
  :domain-knowledge {:legacy-cell "domain-knowledge"
     :phase :event
     :murakumo-node "reuben"
     :collections [(collection "domain-knowledge")]
     :required-gates common-gates
     :trigger "manifest cell domain-knowledge"
     :ceiling "Manifest-driven migration scaffold; explicit execution stays in runtime methods"}
  :facility {:legacy-cell "com-etzhayyim-apps-dataCenterOps-facility"
     :phase :event
     :murakumo-node "reuben"
     :collections [(collection "facility")]
     :required-gates common-gates
     :trigger "manifest cell facility"
     :ceiling "Manifest-driven migration scaffold; explicit execution stays in runtime methods"}
  :rack {:legacy-cell "com-etzhayyim-apps-dataCenterOps-rack"
     :phase :event
     :murakumo-node "reuben"
     :collections [(collection "rack")]
     :required-gates common-gates
     :trigger "manifest cell rack"
     :ceiling "Manifest-driven migration scaffold; explicit execution stays in runtime methods"}
  :powerzone {:legacy-cell "com-etzhayyim-apps-dataCenterOps-powerZone"
     :phase :event
     :murakumo-node "reuben"
     :collections [(collection "powerzone")]
     :required-gates common-gates
     :trigger "manifest cell powerzone"
     :ceiling "Manifest-driven migration scaffold; explicit execution stays in runtime methods"}
  :slawindow {:legacy-cell "com-etzhayyim-apps-dataCenterOps-slaWindow"
     :phase :event
     :murakumo-node "reuben"
     :collections [(collection "slawindow")]
     :required-gates common-gates
     :trigger "manifest cell slawindow"
     :ceiling "Manifest-driven migration scaffold; explicit execution stays in runtime methods"}
  :incident {:legacy-cell "com-etzhayyim-apps-dataCenterOps-incident"
     :phase :event
     :murakumo-node "reuben"
     :collections [(collection "incident")]
     :required-gates common-gates
     :trigger "manifest cell incident"
     :ceiling "Manifest-driven migration scaffold; explicit execution stays in runtime methods"}
  :dependencynode {:legacy-cell "com-etzhayyim-apps-dataCenterOps-dependencyNode"
     :phase :event
     :murakumo-node "reuben"
     :collections [(collection "dependencynode")]
     :required-gates common-gates
     :trigger "manifest cell dependencynode"
     :ceiling "Manifest-driven migration scaffold; explicit execution stays in runtime methods"}
  :dependencyedge {:legacy-cell "com-etzhayyim-apps-dataCenterOps-dependencyEdge"
     :phase :event
     :murakumo-node "reuben"
     :collections [(collection "dependencyedge")]
     :required-gates common-gates
     :trigger "manifest cell dependencyedge"
     :ceiling "Manifest-driven migration scaffold; explicit execution stays in runtime methods"}
})

(defn safe-rkey
  [s]
  (let [clean (-> (str s)
                  (str/replace #"^did:web:" "")
                  (str/replace #"[^A-Za-z0-9._~-]" "-"))]
    (if (str/blank? clean) "unknown" clean)))

(defn gate-value
  [attestations gate]
  (or (get attestations gate)
      (get attestations (name gate))
      (when (set? attestations) (attestations gate))
      (when (set? attestations) (attestations (name gate)))))

(defn missing-gates
  [spec attestations]
  (->> (:required-gates spec)
       (remove #(boolean (gate-value attestations %)))
       vec))

(defn put-record-effect
  [collection rkey record]
  {:op :mst/put-record
   :actor actor-did
   :collection collection
   :rkey rkey
   :record record})

(def asserted-record-keys
  "The fields this actor states about itself rather than accepting from a caller.

  A record written into an append-only store is read later by consumers who have
  no other way to learn who wrote it or under which regime: `$type` is what an
  ATProto consumer dispatches on, `actorDid` is the authorship claim, and
  `scaffold` / `constitutionalStatus` are the record's own admission that it is a
  planned scaffold rather than a ratified action. A caller may repeat any of
  these verbatim -- records round-trip -- but may not change one, because a plan
  that says something different from the actor that produced it is not a plan,
  it is a forgery the store cannot detect afterwards."
  [:$type :actorDid :legacyCell :phase :actorBoundary :scaffold :constitutionalStatus])

(defn normalize-records
  "The caller's records, as a map from collection name or positional index.

  `records-for` reads this by collection name first and by index second, so a
  sequential collection is the index-keyed shape written the obvious way and is
  accepted as one. Anything else -- a set, a string, a number -- carries no
  index this function can honour, and is refused rather than dropped: the plan
  it would otherwise produce is a well-formed instruction to write a record with
  no payload in it, which the host would execute and report as a success."
  [records record]
  (cond
    (map? records)        records
    (sequential? records) (vec records)
    (some? records)       (throw (ex-info "records must be a map or a sequential collection"
                                          {:reason :records/unusable-shape
                                           :records records}))
    (some? record)        {0 record}
    :else                 {}))

(defn assert-provenance!
  "Refuse a supplied record that restates one of `asserted-record-keys` differently."
  [asserted supplied]
  (doseq [k asserted-record-keys]
    (when (and (contains? supplied k)
               (not= (get supplied k) (get asserted k)))
      (throw (ex-info "record may not restate actor provenance with a different value"
                      {:reason :record/forged-provenance
                       :field k
                       :asserted (get asserted k)
                       :supplied (get supplied k)}))))
  supplied)

(defn records-for
  [spec {:keys [records record computed-at request-id]
         :as input}]
  (let [input-records (normalize-records records record)
        defaults {:computedAt computed-at
                  :requestId request-id}]
    (map-indexed
     (fn [idx coll]
       (let [asserted {:$type coll
                       :actorDid actor-did
                       :legacyCell (:legacy-cell spec)
                       :phase (:phase spec)
                       :actorBoundary "cljc-migration-scaffold"
                       :scaffold true
                       :constitutionalStatus "attested-plan"}
             supplied (or (get input-records coll)
                          (get input-records idx)
                          {})
             record* (merge defaults
                            (assert-provenance! asserted supplied)
                            asserted)
             rkey (safe-rkey (or (:rkey record*)
                                 (get record* "rkey")
                                 (:tid record*)
                                 request-id
                                 (str (:legacy-cell spec) "-" idx)))]
         {:collection coll
          :record record*
          :rkey rkey}))
     (:collections spec))))

(defn cell-plan
  [cell-key {:keys [attestations] :as input}]
  (let [spec (get cell-specs cell-key)]
    (when-not spec
      (throw (ex-info "unknown cell" {:cell cell-key})))
    (let [missing (missing-gates spec attestations)]
      (merge
       {:cell cell-key
        :legacy-cell (:legacy-cell spec)
        :actor actor-did
        :phase (:phase spec)
        :murakumo-node (:murakumo-node spec)
        :trigger (:trigger spec)
        :ceiling (:ceiling spec)
        :required-gates (:required-gates spec)
        :missing-gates missing}
       (if (seq missing)
         {:status :blocked
          :effects []}
         (let [planned-records (records-for spec input)]
           {:status :ready
            :records (vec planned-records)
            :effects (mapv (fn [{:keys [collection record rkey]}]
                             (put-record-effect collection rkey record))
                           planned-records)}))))))

(defn all-cell-plans
  [input]
  (into {}
        (map (fn [cell-key] [cell-key (cell-plan cell-key input)]))
        (keys cell-specs)))
