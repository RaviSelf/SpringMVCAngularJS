/**
 * Created by rdemarla on 29-Oct-15.
 **/

var SliderController = {
    direction: 'left',
    currentIndex: 0,
    init: function () {
        //scopeObj = scope;
        return slides = [
            {
                image: 'images/img00.jpg',
                description: 'Image 00'
            },
            {
                image: 'images/img01.jpg',
                description: 'Image 01'
            },
            {
                image: 'images/img02.jpg',
                description: 'Image 02'
            },
            {
                image: 'images/img03.jpg',
                description: 'Image 03'
            },
            {
                image: 'images/img04.jpg',
                description: 'Image 04'
            }
        ];
    },

    setCurrentSlideIndex: function (index) {
        this.direction = (index > this.currentIndex) ? 'left' : 'right';
        this.currentIndex = index;
    },

    nextSlide: function (index) {
        this.direction = 'right';
        this.currentIndex = (this.currentIndex > 0) ? --this.currentIndex : this.init().length - 1;
    },

    isCurrentSlideIndex: function (index) {
        return this.currentIndex === index;
    },

    prevSlide: function () {
        this.direction = 'left';
        this.currentIndex = (this.currentIndex < this.init().length - 1) ? ++this.currentIndex : 0;
    }
};
