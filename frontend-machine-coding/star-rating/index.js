import { StarModel } from "./entities/StarModel.js";

const stars = new StarModel("rating__container", 5, "#eeeeee", "#ff0000");
stars.createStars();