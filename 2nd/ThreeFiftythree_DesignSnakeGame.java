package 二刷;
import java.util.*;

public class ThreeFiftythree_DesignSnakeGame {
	//deque
	int score = 0;
	int width;
	int height;
	int[][] food;
	Deque<Integer> body = new LinkedList<>();
	Set<Integer> set = new HashSet<>();
	int foodIdex = 0;
	public ThreeFiftythree_DesignSnakeGame (int width, int height, int[][] food){
		this.width = width;
		this.height = height;
		this.food = food;
		body.offer(0);
		set.add(0);
	}
	public int move(String direction){
		if(score == -1) return -1;
		int headRow = body.peekFirst() / width;
		int headCol = body.peekFirst() % width;
		switch(direction){
		case "U": headRow--;
		case "D": headRow++;
		case "R" : headCol++;
		default : headCol--;
		}
		//case 1, meet bound or body
		int head = headRow * width + headCol;
		set.remove(body.peekLast());
		if(headRow < 0 || headRow >= height || headCol < 0 || headRow >= width || set.contains(head)){
			return -1;
		}
		//case 2, eat the food
		if(foodIdex < food.length && headRow == food[foodIdex][0] && headCol == food[foodIdex][1]){
			score++;
			set.add(body.peekLast());
			set.add(head);
			body.offerFirst(head);
			foodIdex++;
			return score;
		}
		//case 3, pass the food
		else{
			set.add(head);
			body.offerFirst(head);
			body.pollLast();
			return score;
		}
	}
}
