package com.techtree.portal.controller;


import com.techtree.common.api.CommonResult;
import com.techtree.portal.annotation.CheckLogin;
import com.techtree.portal.model.DO.Student;
import com.techtree.portal.model.DO.StudentCourseRelation;
import com.techtree.portal.model.VO.CourseInfoVo;
import com.techtree.portal.model.VO.StudentAuthVo;
import com.techtree.portal.model.VO.StudentInfoVo;
import com.techtree.portal.model.VO.StudentTokenVo;
import com.techtree.portal.service.CourseService;
import com.techtree.portal.service.impl.CourseServiceImpl;
import com.techtree.portal.service.impl.StudentServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(tags = "学生模块")
@RestController
@RequestMapping("/students")
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;
    @Autowired
    private CourseServiceImpl courseService;
    /**
     * 根据学生id查询学生信息
     * @param id 学生id
     * @return 学生信息
     */

    @GetMapping("/selectById/{id}")
    @ApiOperation(value = "学生主页信息", notes = "根据学生id查询学生信息")
    @ApiImplicitParam(name = "id", value = "学生id", dataType = "String")
    public CommonResult<StudentInfoVo> getStudentById(@PathVariable String id) {
        StudentInfoVo studentById = studentService.getStudentById(id);
        return CommonResult.success(studentById, "查询学生信息成功");
    }

    /**
     * 根据学生姓名查询学生信息
     * @param name 学生姓名
     * @return 学生信息
     */

    @GetMapping("/selectByName/{name}")
    @ApiOperation(value = "学生主页信息", notes = "根据学生姓名查询学生信息")
    public CommonResult<StudentInfoVo> getStudentByName(@PathVariable String name) {
        StudentInfoVo studentByName = studentService.getStudentByName(name);
        return CommonResult.success(studentByName, "查询学生信息成功");
    }

    /**
     * 查询所有学生信息
     * @return 所有学生信息
     */

    @GetMapping("/getAll")
    @ApiOperation(value = "学生主页信息", notes = "查询所有学生信息")
    public CommonResult<List<StudentInfoVo>> getAllStudents(){
        return CommonResult.success(studentService.getAllStudents(), "查询所有学生信息成功");
    }

    /**
     * 新增学生信息
     * @param student 用JSON传入学生的信息
     * @return 添加学生信息成功/失败
     */
    @PutMapping("/add")
    @ApiOperation(value = "添加学生信息", notes = "传入新的学生信息")
    public CommonResult<String> addStudentByJSON(@RequestBody Student student) {
        studentService.addStudent(student);
        return CommonResult.success(null, "添加学生信息成功");

    }

    /**
     * 修改学生信息
     * @param student 用JSON传入学生的信息
     * @return 修改学生信息成功/失败
     */
    @PutMapping("/update")
    @ApiOperation(value = "修改学生信息", notes = "传入新的学生信息")
    public CommonResult<String> updateStudent(@RequestBody StudentInfoVo student) {
        studentService.updateStudent(student);
        return CommonResult.success(null, "修改学生信息成功");
    }

    /**
     * 删除学生信息
     * @param id 删除的学生id
     * @return 修改学生信息成功/失败
     */
    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "删除学生信息", notes = "根据学生id删除学生信息")
    public CommonResult<String> deleteStudentById(@PathVariable String id){
        studentService.deleteStudentById(id);
        return CommonResult.success(null, "删除学生信息成功");
    }

    @GetMapping("/allcourses/{id}")
    @ApiOperation(value = "查询学生选课记录", notes = "根据学生id查询学生选课记录, 没有selected字段")
    public CommonResult<List<StudentCourseRelation>> getStudentCourses(@PathVariable String id){
        List<StudentCourseRelation> studentCourses = studentService.getStudentCourses(id);
        return CommonResult.success(studentCourses, "查询学生选课记录成功");
    }

    @GetMapping("/courses/{id}")
    @ApiOperation(value = "查询学生选课记录", notes = "根据学生id查询所有学生选课记录, 在selected字段标识是否选上")
    public CommonResult<List<CourseInfoVo>> getStudentCourseWithMark(@PathVariable String id) {
        List<CourseInfoVo> allCoursesSelectByStudent = studentService.getAllCoursesSelectByStudent(id);
        return CommonResult.success(allCoursesSelectByStudent, "查询学生选课记录成功");
    }

    @PutMapping("/select/{cid}/{sid}")
    @ApiOperation(value = "选课", notes = "根据课程id和学生id进行选课")
    public CommonResult<Boolean> SelectCourse(@PathVariable String cid, @PathVariable String sid) {
        boolean selectCourse = studentService.selectCourse(cid, sid);
        return CommonResult.success(selectCourse, "选课成功");
    }

    @PutMapping("/withdraw")
    @ApiOperation(value = "退课", notes = "根据课程id和学生id进行退课")
    public CommonResult<Boolean> withdrawCourse(@RequestBody Map<String, Object> withdrawMap) {
        boolean selectCourse = studentService.withdrawCourse(withdrawMap.get("cid").toString(), withdrawMap.get("sid").toString());
        return CommonResult.success(selectCourse, "退课成功");
    }


    @PutMapping("/xcgpwd")
    @ApiOperation(value = "修改密码", notes = "传入学生信息和要修改的修改密码")
    public CommonResult<StudentInfoVo> changePassword(@RequestBody StudentAuthVo student) {
        studentService.updatePassword(student);
        StudentInfoVo studentInfoVo = new StudentInfoVo(student.getId(), student.getName(), student.getSex(), student.getEmail(), student.getMajor());
        return CommonResult.success(studentInfoVo, "修改密码成功");
    }

    @GetMapping("/classmates/{cid}")
    @ApiOperation(value = "查询课友", notes = "输入需要查询的课程id")
    public CommonResult<List<StudentInfoVo>> getStudentsOfCourse(@PathVariable String cid) {
        List<StudentInfoVo> courseStudents = studentService.getCourseStudents(cid);
        return CommonResult.success(courseStudents, "查询课友成功");
    }
}
