var MainController = ["$scope", "ngDialog", function($scope, ngDialog){
	$scope.openLoginWindow = function() {
		ngDialog.open({
			template: 'loginTemplate',
			className: 'ngdialog-theme-default'
		});
	}
}];