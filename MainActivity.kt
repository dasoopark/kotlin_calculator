package kr.co.korearental.calculator

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException
import kotlin.NullPointerException

// 문제 : 5장 연습문제  실습예제 02 개선기 기능 개선

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var num1: Double? = null //첫번쨰 피연산자 실수연산가능하기 위해 double로 선언
        var num2: Double? = null //두번째 피연산자 실수연산가능하기 위해 double로 선언

        //더하기 버튼을 누를때
        BtnAdd.setOnClickListener {
            try {
                num1 = Edit1.text.toString().toDouble() //입력받은 num1을 문자=>double로 변환
                num2 = Edit2.text.toString().toDouble() //입력받은 num2를 문자 ->double로 변환
                TextResult.text = "계산 결과: ${num1!! + num2!!}".toString() //계산결과를 format에 맞게 출력
            } catch (e: NumberFormatException) { //피연산자 값을 입력하지 않았을 때의 예외처리
                Toast.makeText(this, "피연산자 값을 입력하지 않았습니다.", Toast.LENGTH_LONG).show()
                //Toast란: 알람 메시지의 기능을 함
            }
        }

        //빼기 버튼을 누를때
        BtnSub.setOnClickListener {
            try {
                num1 = Edit1.text.toString().toDouble()
                num2 = Edit2.text.toString().toDouble()
                TextResult.text = "계산 결과: ${num1!! - num2!!}".toString()
            } catch (e: NumberFormatException) {  //피연산자 값을 입력하지 않았을 때의 예외처리
                Toast.makeText(this, "피연산자 값을 입력하지 않았습니다.", Toast.LENGTH_LONG).show()
            }
        }

        //곱하기 버튼을 누를때
        BtnMul.setOnClickListener {
            try {
                num1 = Edit1.text.toString().toDouble()
                num2 = Edit2.text.toString().toDouble()
                TextResult.text = "계산 결과: ${num1!! * num2!!}".toString()
            } catch (e: NumberFormatException) { //피연산자 값을 입력하지 않았을 때의 예외처리
                Toast.makeText(this, "피연산자 값을 입력하지 않았습니다.", Toast.LENGTH_LONG).show()
            }
        }

        //나누기 버튼을 누를때
        BtnDiv.setOnClickListener {
            try {
                num1 = Edit1.text.toString().toDouble()
                num2 = Edit2.text.toString().toDouble()
                if (num2 == 0.0) {  //0으로 나눌때 (두번째 피연산자가 0일경우)
                    throw ArithmeticException() //AtrithmeticeException 예외처리 항목으로 이동하라.(Throw의 기능)
                }
                TextResult.text = "계산 결과: ${num1!! / num2!!}".toString()
            } catch (e: ArithmeticException) { //0으로 나눌 경우 발생하는 예외처리 
                TextResult.text = "0으로 나눌 수 없습니다."
                Toast.makeText(this, "0으로 나눌 수 없습니다..", Toast.LENGTH_LONG).show()
            } catch (e: NumberFormatException) { //피연산자 값을 입력하지 않앗을때 발생하는 예외처리
                Toast.makeText(this, "피연산자 값을 입력하지 않았습니다.", Toast.LENGTH_LONG).show()
            }
        }

        BtnModul.setOnClickListener {
            try {
                num1 = Edit1.text.toString().toDouble()
                num2 = Edit2.text.toString().toDouble()

                if (num2 == 0.0) {  //0으로 나머지 연산을 할 때 (두번째 피연산자가 0일경우)
                    throw ArithmeticException() //AtrithmeticeException 예외처리 항목으로 이동하라.(Throw의 기능)
                }
                TextResult.text = "계산 결과: ${num1!! % num2!!}".toString()
            } catch (e: ArithmeticException) {  //0으로 나눌 경우(나머지기능도 포함) 발생하는 예외처리
                TextResult.text = "0으로 나머지 연산 불가능."
                Toast.makeText(this, "0으로 나머지 연산을 할 수 없습니다", Toast.LENGTH_LONG).show()
            } catch (e: NumberFormatException) { //피연산자 값을 입력하지 않았을 때
                Toast.makeText(this, "피연산자 값을 입력하지 않았습니다.", Toast.LENGTH_LONG).show()
            }
        }

    }
}
