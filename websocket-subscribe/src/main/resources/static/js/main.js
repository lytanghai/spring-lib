let stompClient = null;
let subscriptions = {};

function connect() {
    const socket = new SockJS('/ws');
    stompClient = Stomp.over(socket);
    stompClient.debug = null; // disable debug logs

    stompClient.connect({}, () => {
        console.log("Connected");
    });
}

function subscribe() {
    const userId = prompt("Enter User ID");
    const adminId = document.getElementById("adminSelect").value;

    fetch(`/api/subscriptions/subscribe?userId=${userId}&adminId=${adminId}`, { method: 'POST' })
        .then(response => {
            if (response.ok) {
                if (subscriptions[adminId]) {
                    alert("Already subscribed to this admin");
                    return;
                }
                subscriptions[adminId] = stompClient.subscribe("/topic/admin-" + adminId, (message) => {
                    const msg = JSON.parse(message.body);
                    const li = document.createElement("li");
                    li.textContent = `[${msg.adminId}] ${msg.content}`;
                    document.getElementById("messages").appendChild(li);
                });
                alert("Subscribed to " + adminId);
            } else {
                alert("Subscription failed: already subscribed?");
            }
        });
}

function unsubscribe() {
    const userId = prompt("Enter User ID");
    const adminId = document.getElementById("adminSelect").value;

    fetch(`/api/subscriptions/unsubscribe?userId=${userId}&adminId=${adminId}`, { method: 'POST' })
        .then(() => {
            if (subscriptions[adminId]) {
                subscriptions[adminId].unsubscribe();
                delete subscriptions[adminId];
                alert("Unsubscribed from " + adminId);
            }
        });
}

function sendMessage() {
    const adminId = document.getElementById("sendAdminId").value;
    const content = document.getElementById("msgContent").value;

    stompClient.send("/app/sendMessage", {}, JSON.stringify({ adminId, content }));
}

connect();
