<!DOCTYPE html>
<html lang="zh">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta charset="utf-8" />
    <title id="headTitleId">全部用户</title>

    <meta name="description" content="overview &amp; stats" />
    <style type="text/css">
        table
        {
            border-collapse: collapse;
            margin: 0 auto;
            text-align: center;
        }
        table td, table th
        {
            border: 1px solid #cad9ea;
            color: #666;
            height: 30px;
        }
        table thead th
        {
            background-color: #CCE8EB;
            width: 100px;
        }
        table tr:nth-child(odd)
        {
            background: #fff;
        }
        table tr:nth-child(even)
        {
            background: #F5FAFA;
        }
    </style>
</head>
<body>
<table width="90%" class="table">
<tr>
    <th>序号</th>
    <th>id</th>
    <th>phone</th>
    <th>passwd</th>
    <th>num</th>
    <th>remark</th>
</tr>
<#list users as u>
<tr>
    <td>${u?counter}</td>
    <td>${u.id}</td>
    <td>${u.phone}</td>
    <td>${u.passwd}</td>
    <td>${u.num}</td>
    <td>${u.remark!}</td>
</tr>
</#list>
</table>
</body>
</html>