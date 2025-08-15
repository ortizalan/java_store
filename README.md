# Java Store
<img src="java_logo_01.jpg" style="width:30%" />
<div class="container">
  <div class="row">
    <div class="column">
     <H3>¿Qué es Tienda Java?</H3>   
   </div>
  </div>
  <div class="row">
    <div class="col">
      <p>Es una práctica en Java dónde se nos explica que se necesita desarrolloar una aplicación
      de una tienda que registra ventas manualmente como práctica de la POO.</p>
      <p>Se no solicita lo siguiente:</p>
      <ul>
        <li>Registrar productos con su nombre, precio, categoría y stock.</li>
        <li>Administrar clientes con datos básicos como nombre y correo
            electrónico.</li>
        <li>Registrar ventas, indicando el producto vendido, la cantidad y
            asignando la compra a clientes registrados.</li>
        <li>Verificar disponibilidad de stock antes de completar una venta.</li>
        <li>Calcular el total de una venta basada en los precios de los
            productos.</li>
      </ul>
    </div>      
  </div>
  <div class="row">
    <div class="col">
      <p> Por lo que propusimos la siguiente disposición de clases elaborada en PlantUml</p>
      <img src="Diagrama_tienda_java.jpg" />
      <p>Los códigos de las clases se muestran en los siguientes elaces:</p>
      <ul>
        <li>Clase: <a href="Productos.java">Productos.java</a></li>
        <li>Clase: <a href="Clientes.java">Clientes.java</a></li>
        <li>Clase: <a href="Ventas.java">Ventas.java</a></li>
        <li>Clase manejadora: <a href="Ventas.java">Ventas.java</a></li>
      </ul>
    </div>
    <div class="row">
      <div class="col">
        <h3>Descripción de las clases utilizadas:</h3>
        <table>
          <thead>
            <tr style="background-color: #3366cc">
              <th>Clase</th>
              <th>Atributos y propiedades</th>
              <th>Métodos</th>
              <th>Descripción</th>
            </tr>
          </thead>
          <tbody>
            <tr style="background-color: #d6e0f5">
              <td>Productos</td>
              <td>codigo, nombre, precio, precio, categoria, stock</td>
              <td>Productos(), aumentarInventario(), disminuirInventario(), toString()</td>
              <td>Clase que administra los productos, sus precios y existencia del producto</td>
            </tr>
            <tr style="background-color: #99b3e6">
              <td>Clientes</td>
              <td>id_cliente, nombre, email</td>
              <td>Clientes(), toString()</td>
              <td>Clase administradora de clientes, altas y bajas</td>
            </tr>
            <tr style="background-color: #d6e0f5">
              <td>Ventas</td>
              <td>producto, cliente, cantidad, fecha, precioTotal, folio</td>
              <td>Ventas(), generarFolio(), toString()</td>
              <td>Clase que administra las ventas, genera los folios y obtiene la fecha de la venta</td>
            </tr>
            <tr style="background-color: #99b3e6">
              <td>Tienda</td>
              <td>productos, clientes, ventas, count</td>
              <td>Tienda(), addProducto(), getProducto(), listAllProductos(), addCliente(), getCliente(), listAllClientes(),
                  registrarVenta(), listAllVentas(), main()</td>
              <td>Clase manejadora de la tienda, aqui se dan de alta los clientes, productos, se realizan las ventas, se verifica 
                  el inventario del producto, se muestra e imprime el ticket de la venta.</td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</div>
