import { Modal } from "./entities/Modal.js";

document.querySelector("#open-button").addEventListener('click', () => {
    console.log("open-button click");
    new Modal("modal__container", "Hi", "hello");
});