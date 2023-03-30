package net.lectures.springboot.controller;

import net.lectures.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    /*@GetMapping("/student")
    public Student getStudent(){
        Student student = new Student(1,"Yusuf","Senyurt");
        return student;
    }*/

    @GetMapping("/student")
    public ResponseEntity<Student> getStudent(){
        Student student = new Student(1,"Yusuf","Senyurt");
        //return new ResponseEntity<Student>(student,HttpStatus.OK);
        //return ResponseEntity.ok(student); //Üst satırla aynı!

        //Header gönderdik.
        return ResponseEntity.ok().header("custom-header","hasan").body(student);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(2,"Hasan","Senyurt"));
        students.add(new Student(3,"Bilgecan","Dede"));
        return ResponseEntity.ok(students);
    }


    // Spring BOOT REST API with Path Variable
    //localhost:8080/students/1/yusuf/senyurt
    @GetMapping("/{id}/{first-name}/{last-name}") // {id} - URI template variable
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId, @PathVariable("first-name") String firstName, @PathVariable("last-name") String lastName){
        return ResponseEntity.ok(new Student(studentId,firstName,lastName));
    }

    // Spring BOOT REST API with Request Param
    //localhost:8080/students/query?id=1&firstName=yusuf&lastName=senyurt
    @GetMapping("/query")
    public ResponseEntity<Student> studentRequestVariable(@RequestParam int id, @RequestParam String firstName, @RequestParam String lastName){
        return ResponseEntity.ok(new Student(id,firstName,lastName));
    }

    // Spring Boot REST API that handles HTTP Post Request (@PostMapping @RequestBody)

    @PostMapping("/create")
    //@ResponseStatus(HttpStatus.CREATED) //Post yani create'den sonra 201 vermesi gerekiyor. Bunu sağlamak için bu
                                        //annotation'u koyduk.
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<Student>(student,HttpStatus.CREATED); //OK dışında bir return'ü olduğu için .ok kullanmadık!
    }

    // Spring Boot REST API that handles HTTP Put Request (@PostMapping @RequestBody)

    @PutMapping("/{id}/update") //200 OK
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") int studentId){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ResponseEntity.ok(student);
    }

    // Spring Boot REST API that handles HTTP Delete Request

    @DeleteMapping("/{id}/delete") //200 OK
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId){
        System.out.println(studentId);
        return ResponseEntity.ok("Student deleted successfully.");
    }
}
