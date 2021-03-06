(: forest :)
xquery version "1.0-ml";
import module namespace admin = "http://marklogic.com/xdmp/admin" at "/MarkLogic/admin.xqy";
let $config := admin:get-configuration()
let $config := admin:forest-create(
  $config, 
  "top-songs-1",
  xdmp:host(), 
  ())
return admin:save-configuration($config);

(: database :)
xquery version "1.0-ml";
import module namespace admin = "http://marklogic.com/xdmp/admin" at "/MarkLogic/admin.xqy";
let $config := admin:get-configuration()
let $config := admin:database-create(
  $config,
  "top-songs",
  xdmp:database("Security"),
  xdmp:database("Schemas"))
return admin:save-configuration($config);

(: attach forest to database :)
xquery version "1.0-ml";
import module namespace admin = "http://marklogic.com/xdmp/admin" at "/MarkLogic/admin.xqy";
let $config := admin:get-configuration()
let $config := admin:database-attach-forest(
  $config,
  xdmp:database("top-songs"), 
  xdmp:forest("top-songs-1"))
return admin:save-configuration($config);

(: Semicolon is the XQuery transaction separator, to force a commit. :) 
(: Need the commit so that the next step can see what was done in the prior step :)
