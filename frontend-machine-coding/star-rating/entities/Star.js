export class Star {

    constructor(idx, offColor, onColor) {
        this.offColor = offColor;
        this.onColor = onColor;
        this.idx = idx;

        this.starUnicode = "&#9733";
        this.star = this.createStar();
    }

    createStar() {
        let star = document.createElement("span");
        star.innerHTML = this.starUnicode;

        star.style.color = this.offColor;
        star.style.cursor = "pointer"; // pointer cursor

        star.dataset.starIdx =  this.idx;
        return star;
    }

    activateStar() {
        this.star.style.color = this.onColor;
    }

    deactivateStar() {
        this.star.style.color = this.offColor;
    }
}