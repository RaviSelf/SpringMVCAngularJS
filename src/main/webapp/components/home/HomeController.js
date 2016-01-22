/**
 * Created by rdemarla on 29-Oct-15.
 **/
var HomeController = ['$scope', '$interval', function($scope, $interval){
    $scope.currentIndex = SliderController.currentIndex;
    $scope.direction = SliderController.direction;

    $scope.slides = SliderController.init();

    $scope.nextSlide = function (index) {
        return SliderController.nextSlide(index);
    };

    $scope.prevSlide = function () {
        return SliderController.prevSlide();
    };

    $scope.isCurrentSlideIndex = function (index) {
        return SliderController.isCurrentSlideIndex(index);
    };

    $scope.setCurrentSlideIndex = function (index) {
        return SliderController.setCurrentSlideIndex(index);
    };

    $interval(function () {
        $scope.prevSlide();
    }, 5000);
    //console.log($scope.slides, HomeConroller.init());
}];
