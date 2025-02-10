<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>ランキング</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5">
    <h2 class="text-center">ランキング</h2>
    <table class="table table-bordered">
        <thead>
            <tr>
                <th>順位</th>
                <th>ユーザーID</th>
                <th>スコア</th>
            </tr>
        </thead>
        <tbody id="rankingTable">
        </tbody>
    </table>

    <script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>
