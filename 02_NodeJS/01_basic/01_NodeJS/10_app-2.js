const names = require(`./09_users-1`);
const hello = require(`./07_hello`);

for (let i = 0; i < names.length; i++) {
  hello(names[i]);
}
