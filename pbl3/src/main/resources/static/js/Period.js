var arr = document.getElementsByTagName('td');// lẩy thẻ td lưu vào arr
function save()
{



    for(let i=0 ;i<89; i++)
    {
        console.log(arr[i].innerText);// innerText là lấy ra text có trong mảng arr
        if(arr[i].innerText=="")
        {
            alert("Please fill all field");
            return;
        }

        if(isNaN(arr[i].innerText)) {
            alert("Must be fill a number");
            return;
        }
        // $.ajax({
        //     type : "POST",
        //     url : "/save/",
        //     data : {
        //         myArray: arr //notice that "myArray" matches the value for @RequestParam
        //                    //on the Java side
        //     },
        //     success : function(response) {
        //         // do something ...
        //     },
        //     error : function(e) {
        //         alert('Error: ' + e);
        //     }
        // });

    }


}
