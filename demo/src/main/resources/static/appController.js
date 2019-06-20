app.controller('appController', function($scope, $http) {

    $scope.formModel = {};  // Form Model.    

    $scope.gridModel = {};  // Grid Model.
    // Get all students on page load.    

    $http.get("http://localhost:8080/students")
        .then(function (response) {
            $scope.gridModel = response.data;
        });

    // For reload Grid Data after save, update or delete.    

    $scope.reloadData = function(){
        $http.get("http://localhost:8080/students")
            .then(function (response) {
                $scope.gridModel = response.data;
            });
    };

    // For Binding Selected Grid Model to the Form.    

    $scope.bindGridModelToForm = function(model) {
        $scope.formModel = model;
        angular.element('.pointer').removeClass('active-row');
        angular.element('#'+ model.id).addClass('active-row');
    };

    // For New Record.    $scope.new = function(){
        $scope.formModel = {};
    };

    // For Save New Record. After Successful Save Fetch All Records for Updated Data.    

    $scope.save = function(model){
        $http.post('http://localhost:8080/student', JSON.stringify(model))
            .then(function (success) {
                console.log(success);
                $scope.reloadData();
            }, function (error) {
                console.error(error.data);
            });

    };

    // For Update the Existing Record.    $scope.update = function(model){
        $http.put('http://localhost:8080/student', JSON.stringify(model))
            .then(function (success) {
                console.log(success);
                $scope.reloadData();
            }, function (error) {
                console.error(error.data);
            });


    };

    // For Delete the Selected Record.    $scope.delete = function(model){
        $http.delete('http://localhost:8080/student/' + model.id)
            .then(function (success) {
                console.log(success);
                $scope.reloadData();
            }, function (error) {
                console.error(error.data);
            });

    };
});