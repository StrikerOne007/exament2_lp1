<%-- 
    Document   : index.jsp
    Created on : Dec 14, 2025, 2:45:06 AM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Movie"%>
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Mantenimiento de peliculas</title>
        <script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>
        <link href="https://cdn.jsdelivr.net/npm/daisyui@5" rel="stylesheet" type="text/css" />
        <script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>
    </head>
    <body class="min-h-screen bg-black text-gray-200 ">
        <div
            class="bg-cover bg-center h-72 mb-40"
            style="background-image: url('https://blob.elporvenir.mx/images/2020/08/31/streaming-focus-0-0-750-440.jpg');"
        >
            <div class="bg-black/80"><!-- class="bg-black/80" -->

                <header>
                    <div class="flex justify-between max-w-7xl mx-auto px-6 py-4">
                        <div class="flex gap-4">
                            <h1 class="text-lg font-bold text-purple-800">CiNEfix</h1>
                            <span class="text-sm text-gray-300">Catalogo de peliculas</span>
                        </div>
                        <button 
                        onclick=my_modal_2.showModal()                 
                        class="border border-purple-800 px-3 py-1 rounded text-sm font-medium text-white"
                        >
                            + Nuevo titulo
                        </button>
                    </div>
                </header>
                <section class="max-w-7xl mx-auto px-6 py-6 grid grid-cols-12 gap-4 items-end">
                    <div class="col-span-4">
                        <label class="text-sx text-gray-300 mb-1" for="searchInput">Busqueda</label>
                        <input
                            id="searchInput"
                            type="text"
                            placeholder="titulo, Id, nombre..."
                            onkeyup="filtrarPeliculas()"
                            class="w-full bg-black/40 border-white/20 text-sm text-white px-2 py-1">
                    </div>
                    <div class="col-span-2">
                        <label class="text-sx text-gray-300 mb-1" for="filterEstado">Estado</label>
                        <select id="filterEstado" onchange="filtrarPeliculas()" class="w-full bg-black/40 border-white/20 text-sm text-white px-2 py-1">
                            <option value="all">Todo</option>
                            <option value="draft">borrador</option>
                            <option value="QA">QA</option>
                            <option value="published">Publicadas</option>
                        </select>
                    </div>
                    <div class="col-span-2">
                        <label class="text-sx text-gray-300 mb-1" for="filterTipo">Tipo</label>
                        <select id="filterTipo" onchange="filtrarPeliculas()" class="w-full bg-black/40 border-white/20 text-sm text-white px-2 py-1">
                            <option value="all">Todo</option>
                            <option value="movie">peliculas</option>
                            <option value="serie">Series</option>
                        </select>
                    </div>
                    <div class="col-span-4 flex justify-end gap-2">
                        <button id="btnTabla" onclick="mostrarTabla()" class="border border-white/30 text-white px-3 py-1 rounded">
                            Tabla
                        </button>
                        <button id="btnTarjetas" onclick="mostrarTarjetas()" class="border border-purple-800 bg-purple-800/20 text-white px-3 py-1 rounded">
                            Tarjetas
                        </button>
                    </div>

                </section>
                <section >
                    <div class="overflow-hidden relative w-full ">
                        <div class="flex animate-scroll gap-4">
                            <%
                                List<Movie> listaMoviesCarousel = (List<Movie>) request.getAttribute("listaMovies");
                                if (listaMoviesCarousel != null) {
                                    for (int i = 0; i < 2; i++) {
                                        for (Movie movie : listaMoviesCarousel) {
                                            if (movie.getCarousel() != null && movie.getCarousel()) {
                            %>
                                    <div class="flex-shrink-0">
                                        <img class="w-48 h-72 object-cover rounded-box" src="<%= movie.getImageUrl() %>" alt="<%= movie.getTitle() %>" />
                                        <p class="text-sm text-white text-center mt-2"><%= movie.getTitle() %></p>
                                    </div>
                            <%
                                            }
                                        }
                                    }
                                }
                            %>
                        </div>
                    </div>
                    <style>
                        @keyframes scroll {
                        0% { transform: translateX(0); }
                        100% { transform: translateX(-50%); }
                        }
                        .animate-scroll {
                        animation: scroll 20s linear infinite;
                        }
                    </style>
                </section>

            </div>

        </div>

        <main class="mt-8">
            <div id="vistaTabla" class="overflow-x-auto max-w-7xl mx-auto px-6 hidden space-y-4 ">
                <table class="table">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Imagen</th>
                        <th>Título</th>
                        <th>Año</th>
                        <th>Tipo</th>
                        <th>Estado</th>
                        <th>Categoría</th>
                        <th>Rating</th>
                        <th>Duración</th>
                        <th>Acciones</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        List<Movie> listaMovies = (List<Movie>) request.getAttribute("listaMovies");
                        if (listaMovies != null) {
                            for (Movie movie : listaMovies) {
                    %>
                        <tr class="movie-row"
                            data-title="<%= movie.getTitle().toLowerCase() %>"
                            data-type="<%= movie.getType() %>"
                            data-status="<%= movie.getStatus() %>">
                            <td><%= movie.getId() %></td>
                            <td>
                                <img src="<%= movie.getImageUrl() %>" alt="<%= movie.getTitle() %>" class="w-12 h-16 object-cover rounded">
                            </td>
                            <td><%= movie.getTitle() %></td>
                            <td><%= movie.getYear() %></td>
                            <td><%= movie.getType() %></td>
                            <td><%= movie.getStatus() %></td>
                            <td><%= movie.getCategory() %></td>
                            <td><%= movie.getRating() %></td>
                            <td><%= movie.getDuration() %> min</td>
                            <td>
                                <button class="btn btn-xs btn-primary">Editar</button>
                                <button class="btn btn-xs btn-error">Eliminar</button>
                            </td>
                        </tr>
                    <%
                            }
                        }
                    %>
                    </tbody>
                </table>
            </div>
            <div id="vistaTarjetas" class="grid grid-cols-4 gap-6 items-center max-w-7xl mx-auto px-6 py-8">
                <%
                    if (listaMovies != null) {
                        for (Movie movie : listaMovies) {
                %>
                    <div class="movie-card"
                         data-title="<%= movie.getTitle().toLowerCase() %>"
                         data-type="<%= movie.getType() %>"
                         data-status="<%= movie.getStatus() %>">
                        <div class="card card-side bg-base-100 shadow-md mb-2 hover:shadow-xl transition-shadow ">
                            <figure>
                                <img
                                src="<%= movie.getImageUrl() %>"
                                alt="<%= movie.getTitle() %>"
                                class="h-128 object-cover rounded-lg" />
                            </figure>
                        </div>
                        <p class="px-2 py-1 text-base font-semibold"><%= movie.getTitle() %></p>
                        <p class="px-2 text-sm text-gray-400"><%= movie.getYear() %> | ⭐ <%= movie.getRating() %></p>
                    </div>
                <%
                        }
                    }
                %>
            </div>

        </main>
    </body>

    <dialog id="my_modal_2" class="modal">
      <div class="modal-box max-w-lg p-6">
        <h3 class="text-xl font-bold mb-2 text-purple-800">Formulario de película</h3>
        <p class="text-sm text-gray-500 mb-6">Completa todos los campos para registrar una película o serie</p>
        <form action="MovieServlet" method="POST" class="space-y-4">

          <div class="mb-3">
            <label for="title" id="title" class="text-gray-700 block font-medium mb-1">Título de la película:</label>
            <input type="text" name="title" placeholder="Ej: El señor de los anillos" 
                   class="input input-bordered w-full p-2">
          </div>

          <div class="mb-3">
            <label for="slug" id="slug" class="text-gray-700 block font-medium mb-1">Slug (URL amigable):</label>
            <input type="text" name="slug" placeholder="Ej: el-senor-de-los-anillos" 
                   class="input input-bordered w-full p-2">
          </div>

          <div class="mb-3">
            <label for="description" id="description" class="text-gray-700  block font-medium mb-1">Descripción:</label>
            <textarea name="description" placeholder="Breve descripción de la película" 
                      class="textarea textarea-bordered w-full p-2"></textarea>
          </div>

          <div class="flex gap-4 mb-3">
            <div class="flex-1">
              <label for="year" id="year" class="text-gray-700  block font-medium mb-1">Año de estreno:</label>
              <input type="number" name="year" placeholder="Ej: 2023" class="input input-bordered w-full p-2">
            </div>
            <div class="flex-1">
              <label for="duration" id="duration" class="text-gray-700  block font-medium mb-1">Duración (minutos):</label>
              <input type="number" name="duration" placeholder="Ej: 120" class="input input-bordered w-full p-2">
            </div>
          </div>

          <div class="flex gap-4 mb-3">
            <div class="flex-1">
              <label for="type" id="type" class="text-gray-700  block font-medium mb-1">Tipo:</label>
              <select name="type" class="select select-bordered w-full p-2">
                <option value="pelicula">Película</option>
                <option value="serie">Serie</option>
              </select>
            </div>
            <div class="flex-1">
              <label for="status" id="status" class="text-gray-700  block font-medium mb-1">Estado:</label>
              <select name="status" class="select select-bordered w-full p-2">
                <option value="todo">Todo</option>
                <option value="borrador">Borrador</option>
                <option value="revision">Revisión</option>
                <option value="publicado">Publicado</option>
              </select>
            </div>
          </div>

          <div class="mb-3">
            <label for="category" id="category" class="text-gray-700  block font-medium mb-1">Categoría:</label>
            <select name="category" class="select select-bordered w-full p-2">
              <option value="accion">Acción</option>
              <option value="comedia">Comedia</option>
              <option value="drama">Drama</option>
              <option value="terror">Terror</option>
              <option value="cienciaficcion">Ciencia Ficción</option>
              <option value="animacion">Animación</option>
            </select>
          </div>

          <div class="mb-3">
            <label for="imageUrl" id="imageUrl" class="text-gray-700  block font-medium mb-1">URL de la imagen:</label>
            <input type="text" name="imageUrl" placeholder="Ej: https://midominio.com/imagen.jpg" 
                   class="input input-bordered w-full p-2">
          </div>

          <div class="flex gap-4 items-end mb-3">
            <div class="flex items-center gap-2">
              <input type="checkbox" name="carousel" id="carousel" class="checkbox">
              <label for="carousel" id="carousel_label" class="font-medium text-gray-700 ">Mostrar en carrusel</label>
            </div>
            <div class="flex-1">
              <label for="rating" id="rating" class="text-gray-700  block font-medium mb-1">Calificación (rating):</label>
              <input type="number" name="rating" placeholder="Ej: 8.5" step="0.1" 
                     class="input input-bordered w-full p-2">
            </div>
          </div>

          <div class="pt-4">
            <button type="submit" class="btn btn-primary w-full">Enviar</button>
          </div>
        </form>
      </div>

      <form method="dialog" class="modal-backdrop">
        <button class="btn btn-ghost">Cerrar</button>
      </form>
    </dialog>

    <script>
        function mostrarTabla() {
            document.getElementById('vistaTabla').classList.remove('hidden');
            document.getElementById('vistaTarjetas').classList.add('hidden');
            document.getElementById('btnTabla').classList.add('border-purple-800', 'bg-purple-800/20');
            document.getElementById('btnTabla').classList.remove('border-white/30');
            document.getElementById('btnTarjetas').classList.remove('border-purple-800', 'bg-purple-800/20');
            document.getElementById('btnTarjetas').classList.add('border-white/30');
        }

        function mostrarTarjetas() {
            document.getElementById('vistaTarjetas').classList.remove('hidden');
            document.getElementById('vistaTabla').classList.add('hidden');
            document.getElementById('btnTarjetas').classList.add('border-purple-800', 'bg-purple-800/20');
            document.getElementById('btnTarjetas').classList.remove('border-white/30');
            document.getElementById('btnTabla').classList.remove('border-purple-800', 'bg-purple-800/20');
            document.getElementById('btnTabla').classList.add('border-white/30');
        }

        function filtrarPeliculas() {
            const searchTerm = document.getElementById('searchInput').value.toLowerCase();
            const filterTipo = document.getElementById('filterTipo').value;
            const filterEstado = document.getElementById('filterEstado').value;

            const rows = document.querySelectorAll('.movie-row');
            const cards = document.querySelectorAll('.movie-card');

            [rows, cards].forEach(items => {
                items.forEach(item => {
                    const title = item.getAttribute('data-title');
                    const type = item.getAttribute('data-type');
                    const status = item.getAttribute('data-status');

                    const matchSearch = title.includes(searchTerm);
                    const matchTipo = filterTipo === 'all' || type === filterTipo;
                    const matchEstado = filterEstado === 'all' || status === filterEstado;

                    if (matchSearch && matchTipo && matchEstado) {
                        item.style.display = '';
                    } else {
                        item.style.display = 'none';
                    }
                });
            });
        }
    </script>
</html>