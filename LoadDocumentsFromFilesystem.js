declareUpdate();

var pathToSongDocs = '/home/cent/Desktop/mls-fundamentals/unit05/top-songs_data/songs';
var pathToImages = '/home/cent/Desktop/mls-fundamentals/unit05/top-songs_data/images';
var xmlDocs = xdmp.filesystemDirectory(pathToSongDocs);
var binaryDocs = xdmp.filesystemDirectory(pathToImages);

xmlDocs.forEach(function(doc) {
  xdmp.documentLoad(doc.pathname, {'uri': '/songs/' + doc.filename})
});

binaryDocs.forEach(function(doc) {
  xdmp.documentLoad(doc.pathname, {'uri': '/images/' + doc.filename})
});
