package game_object2;



public class Puzzle {
private String id;
String room_id;
private String riddle;
private String hint;
private String answer;


public Puzzle(String id, String room_id, String riddle, String hint, String answer) {
	super();
	this.id = id;
	this.room_id = room_id;
	this.riddle = riddle;
	this.hint = hint;
	this.answer = answer;
}
public String getRoom_id() {
	return room_id;
}
public void setRoom_id(String room_id) {
	this.room_id = room_id;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getRiddle() {
	return riddle;
}
public void setRiddle(String riddle) {
	this.riddle = riddle;
}
public String getHint() {
	return hint;
}
public void setHint(String hint) {
	this.hint = hint;
}
public String getAnswer() {
	return answer;
}
public void setAnswer(String answer) {
	this.answer = answer;
}
@Override
public String toString() {
	return "Puzzle [id=" + id + ", room_id="+room_id +", riddle=" + riddle + ", hint=" + hint
			+ ", answer=" + answer + "]";
}



}