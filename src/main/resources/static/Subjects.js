function _class(name){
  return document.getElementsByClassName(name);
}

let TabSide = _class("sidebar-menu")[0].getElementsByTagName("div");
for (let i = 0; i < TabSide.length; i++) {
    TabSide[i].addEventListener('click', () => {
        let div =  _class("sidebar-menu")[0].getElementsByClassName("active");
        div[0].classList.remove("active");
        TabSide[i].classList.add("active");
    });
}