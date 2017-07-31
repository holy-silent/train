<%--
  Created by IntelliJ IDEA.
  User: xieke
  Date: 2017/7/25
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>管理中心</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
    <link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
    <link href="css/font-awesome.css" rel="stylesheet">
    <link rel="stylesheet" href="css/flexslider.css" type="text/css" media="all" property="" />
    <link href="//fonts.googleapis.com/css?family=Pacifico" rel="stylesheet">
    <link href="//fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i" rel="stylesheet">
    <script src="js/jquery-1.11.1.min.js"></script>
    <script src="js/bootstrap.js"></script>
    <script type="text/javascript">
        jQuery(document).ready(function ($) {
            $(".scroll").click(function (event) {
                event.preventDefault();
                $('html,body').animate({scrollTop: $(this.hash).offset().top}, 1000);
            });
        });
    </script>

    <script type="text/javascript">
        function jump(loc) {
            if (loc == 2) {
                document.getElementById("iframe").src = "/student/showStudentsPages";
            } else if (loc == 3) {
                document.getElementById("iframe").src = "/course/showCoursesPages";
            } else if (loc == 4) {
                document.getElementById("iframe").src = "/score/showScoresPages";
            }
        }
    </script>
</head>
<body>

<!-- banner -->
<div class="banner">
            <div style="height: 70px">
                <p style="font-size: 55px;color: #fbd232;font-family: 楷体;padding-left: 500px">
                    学生管理系统
                </p>
            </div>

             <div class="header-bottom">
                 <div class="" >
                         <!-- Collect the nav links, forms, and other content for toggling -->
                         <ul class="nav navbar-nav" style="font-size: 17px;margin-left: 150px;width: 80%">
                             <%--<li><a onclick="jump(2)">学生信息</a></li>--%>
                             <%--<li><a href="/student/showStudents" target="framename">学生信息</a></li>--%>
                                 <%--<li><a href="user.jsp" target="framename">学生信息</a></li>--%>
                                 <li><a onclick="jump(2)">学生信息</a></li>
                             <li><a onclick="jump(3)">课程信息</a></li>
                             <li><a onclick="jump(4)">分数信息</a></li>
                         </ul>
                 </div>
                  <iframe id="iframe" name="framename" src="welcom.jsp"  class="w3layouts-slider" style="opacity: 0.7;border-radius:20px;margin-left: 150px;width: 80%;height: 500px;background-color:#999999;margin-bottom: 0px;padding-top: 0px;padding-bottom: 0px">

                  </iframe>
             </div>
             <div class="agileits-w3layouts">
                <div class="container">
                      <p>Copyright &copy; 2017.Company name All rights reserved.学生管理系统</p>
                </div>
             </div>
</div>


<!-- //footer -->
<!-- copyright -->
<!-- //copyright -->

<script src="js/responsiveslides.min.js"></script>
<script src="js/jarallax.js"></script>
<script src="js/SmoothScroll.min.js"></script>
<script type="text/javascript">
    /* init Jarallax */
    $('.jarallax').jarallax({
        speed: 0.5,
        imgWidth: 1366,
        imgHeight: 768
    })
</script>
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<!-- here stars scrolling icon -->
<script type="text/javascript">
    $(document).ready(function () {
        /*
         var defaults = {
         containerID: 'toTop', // fading element id
         containerHoverID: 'toTopHover', // fading element hover id
         scrollSpeed: 1200,
         easingType: 'linear'
         };
         */

        $().UItoTop({easingType: 'easeOutQuart'});

    });
</script>
<!-- //here ends scrolling icon -->
<script type="text/javascript">
    $(window).load(function () {
        $("#flexiselDemo1").flexisel({
            visibleItems: 3,
            animationSpeed: 1000,
            autoPlay: true,
            autoPlaySpeed: 3000,
            pauseOnHover: true,
            enableResponsiveBreakpoints: true,
            responsiveBreakpoints: {
                portrait: {
                    changePoint: 480,
                    visibleItems: 1
                },
                landscape: {
                    changePoint: 640,
                    visibleItems: 2
                },
                tablet: {
                    changePoint: 768,
                    visibleItems: 3
                }
            }
        });

    });
</script>
<script type="text/javascript" src="js/jquery.flexisel.js"></script>
</body>
</html>

