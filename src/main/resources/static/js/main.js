function editStudent(id, name, email, password) {
    document.getElementById("editModalForm").action = "/student/update/" + id;
    document.getElementById("editName").value = name;
    document.getElementById("editEmail").value = email;
    document.getElementById("editPassword").value = password;
}

function editTeacher(id, name, email, password) {
    document.getElementById("editModalTeacherForm").action = "/teacher/update/" + id;
    document.getElementById("editNameT").value = name;
    document.getElementById("editEmailT").value = email;
    document.getElementById("editPasswordT").value = password;
}

function editTurma(id, name) {
    document.getElementById("editModalTurmaForm").action = "/team/update/" + id;
    document.getElementById("editNameTurma").value = name;
}

(function($) {

    "use strict";

    var fullHeight = function() {

        $('.js-fullheight').css('height', $(window).height());
        $(window).resize(function() {
            $('.js-fullheight').css('height', $(window).height());
        });

    };
    fullHeight();

    $('#sidebarCollapse').on('click', function() {
        $('#sidebar').toggleClass('active');
    });

})(jQuery);