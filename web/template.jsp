<%-- 
    Document   : template
    Created on : 14/04/2020, 17:37:41
    Author     : pablo
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt" xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>Locadora Carro Bom</title>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <link rel="icon" href="img/favicon.png" />

        <!-- Bootstrap core CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/open-iconic/1.1.1/font/css/open-iconic-bootstrap.min.css" integrity="sha256-BJ/G+e+y7bQdrYkS2RBTyNfBHpA9IuGaPmf9htub5MQ=" crossorigin="anonymous" />

            <!-- Custom styles for this template -->
            <link href="css/styleHome.css" rel="stylesheet" />
    </head>
    <body>
        <header>
            <nav class="navbar navbar-inverse navbar navbar-dark bg-dark fixed-top">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="btn btn-dark navbar-toggle pull-left">
                            <i class="oi oi-menu"></i>
                        </button>
                        <a class="navbar-brand " href="#">CARRO BOM</a>
                    </div>
                </div>
            </nav>
        </header>

        <div class="layout-main"> 
            
<!--         Se usuario tiver logado, aoarece o menu-->
            <c:if test="${sessionScope.user !=null}">

            <aside>
                <nav class="sidebar sidebar-open">
                    <ul class="nav nav-pills">
                        <li class="nav-item"><a class="nav-link " href="/"> <i
                                    class="oi oi-home"></i> <span>Home</span>
                            </a></li>
                    </ul>

                    <ul class="nav nav-pills">
                        <li class="nav-item"><a class="nav-link " href="/"> <i
                                    class="oi oi-home"></i> <span>Alugados</span>
                            </a></li>
                    </ul>
                    <c:if test="${sessionScope.user.ehAdministrador}">
                    <ul class="nav nav-pills">
                        <li class="nav-item"><span class="nav-link active" >Cadastro</span></li>
                        <li class="nav-item">
                            <a class="nav-link" href="#"> <i class="oi oi-plus"></i> 
                                <span>Novo Aluguel</span>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#"> <i class="oi oi-plus"></i> 
                                <span>Categorias</span>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="app?ac=livros"> <i class="oi oi-plus"></i> 
                                <span>Modelos</span>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#"> <i class="oi oi-plus"></i> 
                                <span>Usuários</span>
                            </a>
                        </li>
                    </ul>
                    </c:if>

                    <ul class="nav nav-pills">
                        <li class="nav-item">
                            
                            <a class="nav-link " href="app?ac=logout"> <i
                                    class="oi oi-home"></i> <span>SAIR</span>
                            </a></li>
                    </ul>

                </nav>
            </aside>
            </c:if>
            <section class="layout-content">

                <nav class="navbar navbar-expand-md bg-light">
                    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
                        <ul class="navbar-nav mr-auto">
                            <li class="nav-item active">
                                <i class="oi oi-caret-right"></i>
                                <span>Locadora Carro Bom - ${sessionScope.user.nome}</span>
                            </li>
                        </ul>
                    </div>
                </nav>

                <div class="container">
                    <div id="list-home" class="row">
                        <div class="col-12">
                            <!--                            AQUI REGIÃO INJETÁVEL!!!-->
                            <c:catch var="ex">

                                <c:if test="${param.page == null}">
                                    <jsp:include page="pages/home.jsp" />
                                </c:if>                            
                                <c:if test="${param.page != null}">
                                    <jsp:include page="pages/${param.page}.jsp" />
                                </c:if>

                            </c:catch>
                            <c:if test="${ex != null}" >
                                <h1>ERRO</h1>
                                A página solicitada não existe!!!
                            </c:if>
                        </div>

                    </div>
                </div>

            </section> 

        </div>
        <footer class="layout-footer">
            <div class="container">
                <span class="footer-copy">&copy; PABLO LISBOA PONTES - 2020 POOA. Todos os direitos reservados.</span>
            </div>
        </footer> 

        <!-- Bootstrap core JavaScript
                ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

        <script src="js/jquery.mask.min.js"></script>

        <script type="text/javascript">

            $(function () {
                $('[data-toggle="popover"]').popover();
            });

            $(document).ready(function () {
                $(".navbar-toggle").click(function () {
                    $(".sidebar").toggleClass("sidebar-open");
                });
            });

        </script>
    </body>
</html>
