<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container" id="cadastro"> 
<c:if test="${requestScope.err !=null}">
    <div class="alert-danger"> 
        ${requestScope.err}
    
    </div>
</c:if >    

<form action="app"  id="cadastro" method="post">
    
    
    
    <input type="hidden" name="ac" value="saveUser"/>
    
    <div>
        <label for="name">Nome: </label>
        <input type="text" name="cpNome" id="name" placeholder="Seu Nome" value="${requestScope.user.nome}"/>
    </div>
    <div>
        <label for="mail">E-mail:</label>
        <input type="email" name="cpEmail" id="mail" placeholder="Seu e-mail" value="${requestScope.user.email}"/>
    </div>
    
    <div >
    <label for="login">Login: </label>
    <input type="text" name="cpLogin" id="exampleInputLogin" aria-describedby="loginHelp" placeholder="Seu login" value="${requestScope.user.login}">
   
  </div>
  <div >
    <label for="Password">Senha: </label>
    <input type="password" name="cpSenha"  id="senha" placeholder="Senha" value="${requestScope.user.senha}">
  </div>
 
  <button type="submit" class="btn btn-primary">Enviar</button>
</form>
</div>