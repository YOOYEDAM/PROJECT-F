<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>新規登録</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body class="container mt-5">

    <h2 class="text-center">新規登録</h2>

    <!--メッセージ -->
    <div id="messageBox" class="alert d-none"></div>

    <form id="signupForm" class="mx-auto col-md-6 border p-4 rounded shadow" onsubmit="return false;">
        <div class="mb-3">
            <label class="form-label">ID</label>
            <input type="text" id="userId" name="userId" class="form-control" required>
        </div>

        <div class="mb-3">
            <label class="form-label">パスワード</label>
            <input type="password" id="password" name="password" class="form-control" required>
        </div>

        <div class="mb-3">
            <label class="form-label">名前</label>
            <input type="text" name="name" class="form-control" required>
        </div>

        <div class="mb-3">
            <label class="form-label">メールアドレス</label>
            <input type="email" id="email" name="email" class="form-control" required>
        </div>

        <div class="mb-3">
            <label class="form-label">希望部署</label>
            <select name="department" class="form-select">
                <option value="エンジニア">エンジニア</option>
                <option value="運営">運営</option>
                <option value="営業">営業</option>
            </select>
        </div>

        <button type="submit" class="btn btn-primary w-100" onclick="submitSignup()">登録に進む</button>
    </form>

    <!--Bootstrap JS -->
    <script src="js/bootstrap.bundle.min.js"></script>

    <!-- AJAX -->
    <script>
        function submitSignup() {
            if (!validateForm()) return; //確認

            $.ajax({
                type: "POST",
                url: "SignupAction",
                data: $("#signupForm").serialize(),
                success: function(response) {
                    if (response.trim() === "success") {
                        $("#messageBox").removeClass("d-none alert-danger").addClass("alert-success")
                                       .text("会員登録が正常に行われました。 ログインページに移動します。");
                        setTimeout(() => {
                            window.location.href = "login.jsp"; //ログイン画面に移動
                        }, 2000); // 2秒後にいくように
                    } else {
                        $("#messageBox").removeClass("d-none alert-success").addClass("alert-danger")
                                       .text("重複したIDまたはページエラーです。 情報を再度ご確認の上、再試行してください。");
                    }
                },
                error: function() {
                    $("#messageBox").removeClass("d-none alert-success").addClass("alert-danger")
                                   .text("サーバーにエラーが発生しました。 しばらくしてからもう一度お試しください。");
                }
            });
        }

        function validateForm() {
            let userId = document.getElementById("userId").value;
            let password = document.getElementById("password").value;
            let email = document.getElementById("email").value;

            let idPattern = /[A-Za-z].*\d|\d.*[A-Za-z]/;
            let passPattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&.,'])[A-Za-z\d@$!%*?&.,']{8,16}$/;
            let emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

            if (!idPattern.test(userId)) {
                alert("IDエラー発生。アルファベットと数字を含めて作成してください。");
                return false;
            }

            if (!passPattern.test(password)) {
                alert("パスワードエラー発生。大文字と小文字、数字、特殊記号を含めて作成してください。");
                return false;
            }

            if (!emailPattern.test(email)) {
                alert("メールアドレスエラー発生。有効な電子メール形式ではありません。");
                return false;
            }

            return true;
        }
    </script>

</body>
</html>
