const submit = document.querySelector("#submit");
const postGroup = document.querySelector(".postGroup");

// Set date input value and placeholder as today's date
let todayDate = new Date();
todayDate = todayDate.getFullYear() + "-" + ("0" + (todayDate.getMonth() + 1)).slice(-2) + "-" + todayDate.getDate();
document.querySelector("#date").setAttribute("value", todayDate);
document.querySelector("#date").setAttribute("placeholder", todayDate);

submit.addEventListener("click", () => {
    const date = document.querySelector("#date").value;
    const message = document.querySelector("#text").value;
    const author = document.querySelector("#author").value;
    if (message && author) {
        const post = document.createElement("div");
        post.classList.add("post");
        postGroup.appendChild(post);

        const postMessage = document.createElement("h2");
        postMessage.innerHTML = message;

        const postInfo = document.createElement("div");
        postInfo.classList.add("postInfo");

        const postAuthor = document.createElement("h3");
        postAuthor.innerHTML = author;

        const postDate = document.createElement("h4");
        postDate.innerHTML = date;

        postInfo.appendChild(postAuthor);
        postInfo.appendChild(postDate);

        post.appendChild(postMessage);
        post.appendChild(postInfo);
    } else {
        alert("All fields are mandatory");
    }
})
