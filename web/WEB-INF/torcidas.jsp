<%-- 
    Document   : torcidas
    Created on : 19/10/2022, 10:06:16
    Author     : maluc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">      
    </head>
    <body>
        <c:import url="header.jsp"></c:import>
        <c:import url="menu.jsp"></c:import>
        <div id="piechart_3d" style="width: 900px; height: 500px;"></div>
        
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        <script type="text/javascript">
          google.charts.load("current", {packages:["corechart"]});
          google.charts.setOnLoadCallback(drawChart);
          function drawChart() {
            var data = google.visualization.arrayToDataTable([
              ['Time', 'Número de Torcedores'],  
              <c:forEach var="time" items="${times}">
                  ['${time.nome}', ${time.num_torcedores}],
                </c:forEach>
              ['', 0]
            ]);

            var options = {
              title: 'Torcidas',
              is3D: true,
            };

            var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
            chart.draw(data, options);
          }
        </script>
    </body>
</html>
