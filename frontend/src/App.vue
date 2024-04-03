<template>
    <main class="app">
        <section class="greeting">
        <h3 class="title">✍️ToDo Application</h3>
        </section>
        <div class="input-section">
        <section class="create-todo">
            <form @submit.prevent="addTodo">
            <h3>Adicione suas atividades🙂</h3>
            <input
                type="text"
                placeholder="Escreva aqui"
                v-model="text"
            />
            <input type="submit" value="Add todo" />
            </form>
        </section>
        </div>
        <div class="todo-section">
        <section class="todo-list">
            <h2 v-show="todos.length === 0">Sem atividades no momento😞</h2>
            <div class="list">
            <div
                v-for="todo in todos"
                :class="`todo-item ${todo.done && 'done'}`"
                :key="todo.id"
            >
                <label>
                <input type="checkbox" v-model="todo.done" @change="updateTodo(todo)"/>
                </label>
                <div class="todo-content">
                <input type="text" v-model="todo.description" readonly/>
                </div>
                <div class="actions">
                <button class="delete" @click="deleteTodo(todo)">Delete</button>
                
                </div>
            </div>
            </div>
        </section> 
        </div>
    
    </main>
</template>
    
<script setup>
    import { ref, onMounted, watch } from "vue";
    import axios from 'axios';
    
    const todos = ref([]);
    const text = ref("");

    async function getTodos() {
        try {
            const response = await axios.get("http://localhost:8080/todos");
            if (response && response.data) {
                const todosWithoutQuotes = response.data.map(todo => {
                    return { ...todo, description: todo.description.replace(/^"|"$/g, "").replace(/\\"/g, '"') };
                });
                todos.value = todosWithoutQuotes;
                localStorage.setItem("todos", JSON.stringify(todosWithoutQuotes));
            } else {
                console.error('Resposta do servidor está vazia ou não contém dados.', response);
            }
        } catch (error) {
            console.error('Erro ao obter todos:', error);
        }
}

    async function addTodo() {
        if (text.value.trim() === "") {
            console.error("O texto do todo não pode estar vazio.");
            return;
        }
        
        let description = text.value.trim();
        const data = description.replace(/^"|"$/g, "").replace(/\\"/g, '"');
    
        const config = {
            headers: {
                'Content-Type': 'application/json'
            }
        };
    
        try {
            const response = await axios.post("http://localhost:8080/todos", data, config);
            if (response && response.data) {
                getTodos();
                text.value = "";
            } else {
                console.error('Resposta do servidor está vazia ou não contém a propriedade "data".', response);
            }
        } catch (error) {
            console.error('Erro ao adicionar o todo:', error);
        }
    }
    
    async function deleteTodo(todo) {
        try {
            const response = await axios.delete(`http://localhost:8080/todos/${todo.id}`);
            if (response && response.status === 204) {
                getTodos();
            } else console.log(response.status);
        } catch (error) {
            console.error('Erro ao excluir o todo:', error);
        }
    }

    async function updateTodo(todo) {
    try {
        const response = await axios.put(`http://localhost:8080/todos/${todo.id}`, todo);
        if (response && response.data) {
            console.log("updated");
        } else {
            console.error('Resposta do servidor está vazia ou não contém dados.', response);
        }
    } catch (error) {
        console.error('Erro ao atualizar o todo:', error);
    }
}

watch(
    todos,
    (newTodoValue) => {
        const todosWithoutQuotes = newTodoValue.map(todo => {
            return { ...todo, description: todo.description.replace(/^"|"$/g, "").replace(/\\"/g, '"') };
        });
        localStorage.setItem("todos", JSON.stringify(todosWithoutQuotes));
    },
    { deep: true }
);
    
    onMounted(() => {
        todos.value = JSON.parse(localStorage.getItem("todos")) || [];
    });
    </script>
    