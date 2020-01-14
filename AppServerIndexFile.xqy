xdmp:set-response-content-type("text/html"),
<h1>{fn:doc("/fun/hello.xml")}</h1>,
<h1>{fn:doc("/fun/hello.json")/data()}</h1>
