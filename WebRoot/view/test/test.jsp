<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<html>
<head>
    <script>
        //合并表格第一列相同内容
        function mergeTable(tabObj,colIndex){
            if(tabObj != null){
                var i,j;
                var intSpan;
                var strTemp;
                for(i = 0; i < tabObj.rows.length; i++){
                    intSpan = 1;
                    strTemp = tabObj.rows[i].cells[colIndex].innerText;
                    for(j = i + 1; j < tabObj.rows.length; j++){
                        if(strTemp == tabObj.rows[j].cells[colIndex].innerText){
                            intSpan++;
                            tabObj.rows[i].cells[colIndex].rowSpan = intSpan;
                            tabObj.rows[j].cells[colIndex].style.display = "none";
                        }else{
                            break;
                        }
                    }
                    i = j - 1;
                }
            }
        }

    </script>
</head>
<body onload="mergeTable(table1,0)">
<table width="400" border="1" id="table1">
    <tr>
        <td>内容相同</td>
        <td>豆腐干</td>
        <td>2016-10-31</td>
    </tr>
    <tr>
        <td>内容相同</td>
        <td>豆腐干</td>
        <td>2016-10-31</td>
    </tr>
    <tr>
        <td>内容不相同</td>
        <td>回复的</td>
        <td>2016-10-31</td>
    </tr>
</table>
</body>
</html>