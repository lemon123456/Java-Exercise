$(function () {

    $('#insertButton').on('click', function () {
        $('#insertCourseForm').toggle();
    });

    //$('.deleteButton').on('click',function(){
    //    if (confirm("确定要删除吗？")) {
    //        course = this;
    //        var id = course.closest('td').id;
    //        $.ajax({
    //            url: '/web/course/' + id,
    //            type: 'DELETE',
    //            dataType: 'text',
    //            success: function () {
    //                course.closest('tr').remove();
    //            }
    //        })
    //    }
    //});

    //$('.updateButton').on('click', function () {
    //    var id = $(this).closest('tr').children('.course-id').text();
    //    var name = $(this).closest('tr').children('.course-name').text();
    //    var description = $(this).closest('tr').children('.course-description').text();
    //
    //    $('#idInput').val(id);
    //    $('#nameInput').val(name);
    //    $('#descriptionInput').val(description);
    //    $('#updateCourseForm').toggle();
    //});

    var course;
    $('#courseTable').on('click', '.deleteButton', function () {
        if (confirm("确定要删除吗？")) {
            course = this;
            var id = course.closest('td').id;
            $.ajax({
                url: '/web/course/' + id,
                type: 'DELETE',
                dataType: 'text',
                success: function () {
                    course.closest('tr').remove();
                }
            })
        }
    });

    $('#courseTable').on('click', '.updateButton', function () {
        var id = $(this).closest('tr').children('.course-id').text();
        var name = $(this).closest('tr').children('.course-name').text();
        var description = $(this).closest('tr').children('.course-description').text();

        $('#idInput').val(id);
        $('#nameInput').val(name);
        $('#descriptionInput').val(description);
        $('#updateCourseForm').toggle();
    });


    $('#updateCourseForm').submit(function (e) {
        e.preventDefault();
        var name = $('#nameInput').val();
        if (name == "") {
            alert("Name can not be set null!");
            return false;
        }
        var id = $('#idInput').val();
        var description = $('#descriptionInput').val();
        $.ajax({
            url: '/web/course/update',
            type: 'PUT',
            dataType: 'json',
            data: {"id": id, "courseName": name, "description": description},
            success: function (result) {
                $('#updateCourseForm').hide();
                var td = 'tr #' + result.id;
                $(td).siblings('.course-name').text(result.courseName);
                $(td).siblings('.course-description').text(result.description);
            }
        });
    });


    $('.insertButton').on('click', function () {
        course = this;
        var name = $('#nameInsert').val();
        if (name == "") {
            alert("Name can not be set null!");
            return;
        }
        var form = $('#insertCourseForm');
        $.ajax({
            url: '/web/course',
            type: 'POST',
            dataType: 'json',
            data: form.serialize(),
            success: function (data) {
                $('#insertCourseForm').hide();
                $("#courseTable").append("<tr>" +
                "<td class='course-id'>" + data.id + "</td>" +
                "<td class='course-name'>" + data.courseName + "</td>" +
                "<td class='course-description'>" + data.description + "</td>" +
                "<td id=" + data.id + "><button class='button deleteButton'>删除</button></td>" +
                "<td><button class='button updateButton'>更新</button></td>" + "</tr>");
                //window.location.reload();
            }
        })
    })

});








