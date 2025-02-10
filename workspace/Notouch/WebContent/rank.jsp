<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>スコア登録</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body class="container mt-5">

    <h2 class="text-center">スコア登録</h2>

    <div id="messageBox" class="alert d-none"></div>

    <form id="scoreForm" class="mx-auto col-md-6 border p-4 rounded shadow" onsubmit="return false;">
        <div class="mb-3">
            <label class="form-label">ユーザーID</label>
            <input type="text" id="userId" name="userId" class="form-control" required>
        </div>

        <div class="mb-3">
            <label class="form-label">スコア</label>
            <input type="number" id="score" name="score" class="form-control" required min="0">
        </div>

        <button type="submit" class="btn btn-primary w-100" onclick="submitScore()">登録</button>
    </form>

    <script src="js/bootstrap.bundle.min.js"></script>

    <script>
        function submitScore() {
            $.ajax({
                type: "POST",
                url: "RankingAction",
                data: $("#scoreForm").serialize(),
                success: function(response) {
                    if (response.trim() === "success") {
                        $("#messageBox").removeClass("d-none alert-danger").addClass("alert-success")
                                       .text("スコアが登録されました！ランキングページに移動します。");
                        setTimeout(() => {
                            window.location.href = "ranking.jsp";
                        }, 2000);
                    } else {
                        $("#messageBox").removeClass("d-none alert-success").addClass("alert-danger")
                                       .text("登録に失敗しました。もう一度試してください。");
                    }
                },
                error: function() {
                    $("#messageBox").removeClass("d-none alert-success").addClass("alert-danger")
                                   .text("サーバーエラーが発生しました。後でもう一度お試しください。");
                }
            });
        }
    </script>

</body>
</html>
