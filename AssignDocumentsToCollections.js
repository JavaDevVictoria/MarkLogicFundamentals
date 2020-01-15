declareUpdate();
var characters = xdmp.directory('/character/');
characters.toArray().forEach(function(character) {
  var c_uri = fn.baseUri(character);
  xdmp.documentAddCollections(c_uri, 'character');
});
var images = xdmp.directory('/image/');
images.toArray().forEach(function(image) {
  var i_uri = fn.baseUri(image);
  xdmp.documentAddCollections(i_uri, 'image');
});
