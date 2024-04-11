var user = 'admin';
var password = 'root';
var authDb = 'admin';
var newDb = 'ms-notification';

db.createUser({
    user: user,
    pwd: password,
    roles: [{ role: 'readWrite', db: newDb }]
});

db = db.getSiblingDB(newDb);
db.createCollection('your_collection');
