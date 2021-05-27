class Student {
    constructor(id, name, class1, phone, email){
        this.id = id;
        this.name = name;
        this.class1 = class1;
        this.phone = phone;
        this.email = email;
    }
}

class UI {
    static displayStudents(){
        const students  = Store.getStudents();
        students.forEach((student) => UI.addStudent(student));
    }

    static addStudent(student){
        const list = document.getElementById('student-list');
        const newStudent = document.createElement('tr');
        newStudent.innerHTML = `
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.class1}</td>
            <td>${student.phone}</td>
            <td>${student.email}</td>
            <td><a href="" class="btn btn-danger btn-sm delete">X</a></td>
        `;
        list.appendChild(newStudent);
    }

    static clearField(){
        document.getElementById('id').value = '';
        document.getElementById('name').value = '';
        document.getElementById('class1').value = '';
        document.getElementById('phone').value = '';
        document.getElementById('email').value = '';
    }

    static removeStudent(e){
        if(e.classList.contains('delete')){
            if(confirm("Bạn chắc chắn có muốn xóa không ?")){
                e.parentElement.parentElement.remove();
            }
        }
    }

    static showAlert(message, className){
        const container = document.querySelector('.container');
        const form = document.querySelector('#student-form');
        const div = document.createElement('div');
        div.className = `alert alert-${className}`;
        div.appendChild(document.createTextNode(message));
        container.insertBefore(div, form);
        setTimeout(() => document.querySelector('.alert').remove(), 3000);
    }
}

class Store {
    static getStudents(){
        let students;
        if(localStorage.getItem('students') == null){
            students = [];
        } else {
            students = JSON.parse(localStorage.getItem('students'));
        }
        return students;
    }

    static addStudent(student){
        const students = Store.getStudents();
        students.push(student);
        localStorage.setItem('students', JSON.stringify('students'));
    }

    static removeTeacher(id){
        const students = Store.getStudents();
        students.forEach((student, index) => {
            if(student.id === id){
                students.splice(index, 1);
            }
            localStorage.setItem('students', JSON.stringify('students'));
        });
    }
}

document.addEventListener('DOMContentLoaded', UI.displayStudents);

const form = document.getElementById('student-form');
form.addEventListener('submit', add);
function add(e){
    e.preventDefault();
    const id = document.getElementById('id').value;
    const name = document.getElementById('name').value;
    const class1 = document.getElementById('class1').value;
    const phone = document.getElementById('phone').value;
    const email = document.getElementById('email').value;

    if(id === '' || name === '' || class1 === '' || phone === '' || email === ''){
        UI.showAlert('Chú ý điền đầy đủ thông tin', 'danger');
    } else {
        const student = new Teacher(id, name, class1, phone, email);
        UI.addTeacher(student);
        Store.addTeacher(student);
        UI.clearField();
        UI.showAlert('Đã thêm học sinh mới', 'success');
    }
}

const list = document.getElementById('student-list');
list.addEventListener('click', remove);
function remove(e){
    e.preventDefault();
    UI.removeTeacher(e.target);
    Store.removeTeacher(e.target.parentElement.previousElementSibling.textContent);
    UI.showAlert('Đã xóa học sinh', 'success');
}