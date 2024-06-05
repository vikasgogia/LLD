import { Star } from "./Star.js";

export class StarModel {

    constructor(elementId, count, defaultColor, starColor) {
        // get the config for creating stars
        this.elementId = elementId;
        this.count = count;
        this.defaultColor = defaultColor;
        this.starColor = starColor;

        // get the container for displaying stars
        this.container = document.querySelector(`#${this.elementId}`);
        this.stars = [];
    }

    createStars() {
        if(!this.container) return;
        
        // create a fragment & add all stars to fragment
        let fragment = document.createDocumentFragment();
        for(let i=0; i< this.count; i++) {
            const star = new Star(i, this.defaultColor, this.starColor);
            this.stars.push(star);
            fragment.appendChild(star.star);
        }

        // appends a node as the last child of the container
        this.container.appendChild(fragment);
        this.prevFill = -1;

        // event listeners
        this.container.addEventListener('click', this.onClick.bind(this));
        this.container.addEventListener('mouseover', this.onMouseOver.bind(this));
        this.container.addEventListener('mouseleave', this.onMouseLeave.bind(this));
    }

    onClick(e) {
        let clickedStar = Number(e.target.dataset.starIdx);
        if(!clickedStar) return;

        if(clickedStar < this.prevFill) {
            // turn previous stars off
            for(let i=clickedStar+1; i<= this.prevFill; i++) {
                this.stars[i].deactivateStar();
            }
        }
        else {
            // turn new stars on
            for(let i=this.prevFill+1; i<= clickedStar; i++) {
                this.stars[i].activateStar();
            }
        }

        this.prevFill = clickedStar;
    }

    onMouseOver(e) {
        let hoveredStar = Number(e.target.dataset.starIdx);
        if(!hoveredStar) return;

        // turn all stars off
        for(let i=0; i< this.stars.length; i++) {
            this.stars[i].deactivateStar();
        }

        // turn hovered stars on
        for(let i=0; i<= hoveredStar; i++) {
            this.stars[i].activateStar();
        }
    }

    onMouseLeave(e) {
        
        // turn all stars off
        for(let i=0; i< this.stars.length; i++) {
            this.stars[i].deactivateStar();
        }

        // turn prevFill on
        for(let i=0; i<= this.prevFill; i++) {
            this.stars[i].activateStar();
        }
    }
}