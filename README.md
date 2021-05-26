# Rules of Snake And Ladder Ludo Game : 

- Game can have multiple participants.
- Goal is to reach exact score 100. The one who reaches first is winner. Game ends if any one of player reaches at end. i.e. on value exactly “100”. 
- Game will be played by help of dice, which have printed value 1 to 6.
- Retry Dice, when Dice value faces 6, except the scenarios - Total score of the player shouldn't be in between 95 to 99 (because then it'll crosses 100) OR it shouldn't be snake's head. Also if got ladder, get opportunity to play dice again.
- Players will be promted to Ladder’s head if total score after rolling dice got equivalent to Ladder’s tail. Where as they will be demoted to Snake’s tail, if total score after rolling dice got equivalent to snake’s mouth.

# Approach :
- Capture positions where snake’s head and tail exists.
- Capture positions where ladder starts and ends.
- Use Java Random class to use generate dice value. Capture the dice value and sum up score with taking care of Snake's head & Ladder's tail.

# Run the given code as java program. You'll get output at console.

# How Snake and Ladder game look alike pictorially: 
![](https://github.com/AadityaUoHyd/SnakeAndLadder-Ludo-Game/blob/main/IMG_20210526_115617.jpg)


