package com.calculator.client;

import java.util.Collection;
import java.util.List;

import com.calculator.domain.Student;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.client.Traverson;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class StudentClient {

  private final RestTemplate rest;
  private final Traverson traverson;

  public StudentClient(RestTemplate rest, Traverson traverson) {
    this.rest = rest;
    this.traverson = traverson;
  }

  //
  // GET examples
  //

  /*
   * Specify parameter as varargs argument
   */
  public Student getStudentById(String studentId) {
    return rest.getForObject("http://localhost:8080/students/{id}",
                             Student.class, studentId);
  }



  public List<Student> getAllStudents() {
    return rest.exchange("http://localhost:8080/students",
            HttpMethod.GET, null, new ParameterizedTypeReference<List<Student>>() {})
        .getBody();
  }

  //
  // PUT examples
  //

  public void updateStudent(Student student) {
    rest.put("http://localhost:8080/ingredients/{id}",
            student, student.getId());
  }

  //
  // POST examples
  //
  public Student createStudent(Student student) {
    return rest.postForObject("http://localhost:8080/ingredients",
            student, Student.class);
  }


  //
  // DELETE examples
  //

  public void deleteStudent(Student student) {
    rest.delete("http://localhost:8080/ingredients/{id}",
            student.getId());
  }

  //
  // Traverson with RestTemplate examples
  //

  public Iterable<Student> getAllIngredientsWithTraverson() {
    ParameterizedTypeReference<CollectionModel<Student>> studentType =
        new ParameterizedTypeReference<CollectionModel<Student>>() {};

    CollectionModel<Student> studentRes =
        traverson
          .follow("ingredients")
          .toObject(studentType);
    
    Collection<Student> students = studentRes.getContent();
          
    return students;
  }

  public Student addIngredient(Student ingredient) {
    String studentsUrl = traverson
        .follow("students")
        .asLink()
        .getHref();
    return rest.postForObject(studentsUrl,
                              ingredient,
            Student.class);
  }

//  public Iterable<Taco> getRecentTacosWithTraverson() {
//    ParameterizedTypeReference<CollectionModel<Taco>> tacoType =
//        new ParameterizedTypeReference<CollectionModel<Taco>>() {};
//
//    CollectionModel<Taco> tacoRes =
//        traverson
//          .follow("tacos")
//          .follow("recents")
//          .toObject(tacoType);

      // Alternatively, list the two paths in the same call to follow()
//    Resources<Taco> tacoRes =
//        traverson
//          .follow("tacos", "recents")
//          .toObject(tacoType);

//    return tacoRes.getContent();
//  }

}
