(ns ftasolver.core)



(def playerid "1")
(def server-address "http://localhost:8081/")


(defn post-json [address json]
	(let [connection (doto (.openConnection (new java.net.URL address)) (.setDoOutput true))]
		(doto (new java.io.PrintWriter (new java.io.OutputStreamWriter (.getOutputStream connection) "utf-8"))
			(.append json) (.close))
		(slurp (.getInputStream connection))
	)
)


(defn -main [& m]
	(post-json (str server-address "/game/shoot/" playerid) "[[0,0],[1,0]]")
	)