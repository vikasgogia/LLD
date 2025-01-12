const client = require('./client');

const init = async () => {
    // set a key-value
    await client.set("user:2", "vikas");

    // set an expiry (TTL) for 10 seconds
    await client.expire("user:2", 10);

    // get a value
    const result = await client.get("user:2");

    console.log(result);
}

init();