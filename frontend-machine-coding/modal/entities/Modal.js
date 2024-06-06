export class Modal {

    constructor(elementId, title, content) {
        // get the config for creating stars
        this.title = title;
        this.content = content;

        this.container = document.querySelector(`#${elementId}`);

        this.createModal();
    }

    createModal() {
        if(!this.container) return;

        // define header for the modal conponent
        let modalHeader = document.createElement('div');
        modalHeader.innerHTML = `
            <div class="modal__header">
                <div>${this.title}</div>
                <button>&times;</button>
            </div>
        `;

        // define body for the modal component
        let modalBody = document.createElement('div');
        modalBody.innerHTML = this.content;

        let fragment = document.createDocumentFragment();
        fragment.appendChild(modalHeader);
        fragment.appendChild(modalBody);

        this.container.appendChild(fragment);
    }
}