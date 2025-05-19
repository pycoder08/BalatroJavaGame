[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=19397585)
# Unit Deliverable<br><sup>Starter Project<sup>

# JAVA CARD GAME
In this program based off of the game [Balatro](https://www.playbalatro.com/), the player selects and plays hands of cards in an attempt to beat the target score and win the game.

## How to play
![Image of the game](https://github.com/user-attachments/assets/e1b7b946-2600-4f34-8756-64a34ef467a5)

The game consists of 5 levels, each with an increasingly difficult target score to beat. To start, the player enters numbers 1 through 7 to select a card in their hand. They select a maximum of 5 cards, and can choose to either play the hand or discard it. 
When a hand is played, the program detects if it forms one of the following *hands*:
| Hand | Description |
| ----------- | ----------- |
| Straight | 5 cards in increasing order |
| Flush | 5 cards of the same suit |
| Straight Flush | 5 Cards of the same suit and increasing order |
| 2 of a kind | Two cards of the same rank |
| 3 of a kind | Three cards of the same rank |
| 4 of a kind | Four cards of the same rank |
| Two pair | Two pairs of cards of the same rank |
| Full house | A three of a kind and two of a kind | 
| High card | Scores the highest card |

The player can access this info at any time by entering 'h' into the game

![Image of the help screen](https://cdn.discordapp.com/attachments/1240802108098482199/1374160593963188304/image.png?ex=682d0a48&is=682bb8c8&hm=bae4d58e95ec3224a3d704aee124673ff8b9c1ece2f61efc7bd337157e1ebfaf&)

Notable exception: A straight can be played with an ace, 10, jack, queen, and king, despite the ace not being strictly part of the increasing order

![Image of special straight case](https://github.com/user-attachments/assets/cbf174c0-9596-47d9-b924-cbf4e19135d9)

Each hand comes with a base number of points and a multiplier, encouraging the player to form more difficult hands. After the player enters their hand, each card scores as high as its rank (or 11 for an ace), and that score is added to the base number of points for the hand. 

Once the cards have been scored, the points are multiplied by the hand's multiplier, and the resulting score is added to the total (seen in yellow on the score board). 

![Image of score board](https://github.com/user-attachments/assets/6556037e-8ddf-4be6-9f96-52575ff082a2)

Once the player scores enough to beat the target in the top right, they win, and move on to the next stage.

The player loses if they run out of hands before they meet the goal.
