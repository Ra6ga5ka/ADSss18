import random

numberOfStacks = 4

def nimAction(player):
    if len(stack)==1:
        stack.remove(stack[0])
        return "player "+str(player)+" took the last stack"
    
    elif len(stack)>2 and len(stack)%2 ==1:
        smallestStack = 0
        smallesStackSize =stack[0]
        index = 0
        for i in stack:
            if i > smallesStackSize:
                smallestStack = index
            index += 1
        removeAmmount = stack[smallestStack]-1
        print(removeAmmount)
        if(removeAmmount == 0):
            stack.remove(stack[smallestStack])
            return "player "+str(player)+" took the stack nr "+str(smallestStack+1)
        else:
            stack[smallestStack]=1
            return "player "+str(player)+" took "+str(removeAmmount)+" from the stack nr "+str(smallestStack+1)
        
    elif len(stack)>2 :
        smallestStack = 0
        smallesStackSize =stack[0]
        index = 0
        for i in stack:
            if i < smallesStackSize:
                smallestStack = index
            index += 1
        stack.remove(stack[smallestStack])
        #print(smallestStack)
        return "player "+str(player)+" took the stack nr "+str(smallestStack+1)

    elif len(stack) == 2:   
        if stack[0] >2 and stack[1]>2:
            smallestStack = 0
            smallesStackSize =stack[0]
            index = 0
            for i in stack:
                if i < smallesStackSize:
                    smallestStack = index
                index += 1
            out = "player "+str(player)+" took "+ str(stack[smallestStack]-2)+" from stack nr "+str(smallestStack+1)
            stack[smallestStack-1] = 2
            return out
        elif stack[0] ==1 and stack[1] >=2:
            out = "player "+str(player)+" took "+ str(stack[1]-1)+" from stack nr 1"
            stack[1] = 1
            return out
        elif stack[1] ==1 and stack[0] >=2:
            out = "player "+str(player)+" took "+ str(stack[0]-1)+" from stack nr 1"
            stack[0] = 1
            return out
        else: 
            stack.remove(stack[0])
            return "player "+str(player)+" took the stack nr "+ str(1)
    else:
        return "player "+str(player)+" did nothing because something went wrong"

result = []
for i in range(0,numberOfStacks):
    stack=[random.randint(1,10) for j in range(random.randint(2,10))]
    print(stack)
    result.append(["game number: "+str(i)+" with stack: "+str(stack)])
    while len(stack)>0:
        for player in range(0,2):
            
            #result[i].append(nimAction(player))
            out = nimAction(player)
            print(out)
            result[i].append(out)
            if len(stack)== 0:
                result[i].append("player "+str(player)+" won the match nr "+str(i+1))
                break

for game in result:
    for entry in game:
        print(str(entry))
#print(result)
    




