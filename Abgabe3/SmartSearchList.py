#Aufgabe 3 von Robin Schmidt, Max Verpers, Milena Stück Python variante

import time
import random
import re

class Node:
    def __init__(self,next,obj):
        self.next = next #going to use an array to increase searchspeed
        #self.parent = parent
        self.obj = obj #Compareable
        self.occurance = 1

    def __repr__(self):
        return str(self.obj)

    def __str__(self):
        return str(self.obj)

    def __next__(self):
        return self.next

class SearchList:
    def __init__(self,height,jumpDistance):
        self.height = height
        self.head=None
        self.len = 0
        self.lastHeight = height
        self.jumpDistance = jumpDistance
        self.offset = jumpDistance
    
    def internalSearch(self, obj,lowestSearchLevel):
        """ returns the node that is the direct parent of the searched Item"""
        currentPos = self.head
        return self.recursiveSearch(currentPos,obj,lowestSearchLevel)
    
    def recursiveSearch(self,current, obj,lowestSearchLevel):
        if current.next[lowestSearchLevel] is not None and current.next[lowestSearchLevel].obj<obj: # precheck the lowest level to make shure that the loop is nessesary
            for i in range(len(current.next)-1,lowestSearchLevel-1,-1):                             # check if the farestest jump leeds to a valid position
                if current.next[i] is not None and current.next[i].obj<obj:
                    return self.recursiveSearch(current.next[i], obj,lowestSearchLevel)             # returns the destination node of the farest valid jump
        else:  
            return current  # if there follows no node at the lowest search possition the current node is the parent node for the searched object


    def __add__(self, value):
        
        if self.head == None: # adds a headnode if the list is empty
            next = []
            for i in range(0,self.height):
                next.append(None)
            self.head = Node(next,value)
            self.len = self.len+1
        elif self.head.obj > value: # replaces the headnode and adds
            next = []
            for i in range(0,self.height):
                next.append(self.head)
            newNode=Node(next,value)
            self.head = newNode
            self.len = self.len+1
        else:
            #this controls the height of the current node.
            # the area blow makes shure that never follow 2 identical heightvalues to speedup the internal search to O(log(n))
            self.offset +=1
            if self.offset >= self.jumpDistance:
                self.offset = 0
                self.lastHeight += 1
                if self.lastHeight >= self.height:
                    self.lastHeight = 1
                nodeHeight = random.randint(1,self.lastHeight)
            else:
                nodeHeight = 1

            parentPositions = []
            for i in range (0,nodeHeight):
                parentPositions.append(self.internalSearch(value,i))

            if parentPositions[0].next[0] is not None and parentPositions[0].next[0].obj == value:
               parentPositions[0].next[0].occurance += 1
               return 

            next = []
            for i in range(0,len(parentPositions)):
                next.append(parentPositions[i].next[i])

            #print(value,next)
            
            newNode = Node(next,value)
            for i in range(0,len(parentPositions)):
                parentPositions[i].next[i] = newNode
            
            self.len = self.len+1

    def __len__(self):
        return self.len

    def __iter__(self):
        self.IterPos = self.head
        return self
    
    def __next__(self):
        self.IterPos =self.IterPos.next[0]
        if self.IterPos is None:
            raise StopIteration  # signals "the end"
        return self.IterPos

    def __str__(self):
        line = ""
        for obj in self:
            line = line+" "+ str(obj)

        return line
  
    def search(self,obj):
        return self.internalSearch(obj,0).next[0]

    def add(self, obj):
        """ komplexity O(N)"""
        __add__(obj)

    def noOccurences(self):
        """ complexity O(n)"""
        currentPos = self.head
        occurance = 0
        if currentPos is not None:
            while True:
                occurance += currentPos.occurance
                if currentPos.next[0] is None:
                    break
                currentPos = currentPos.next[0]
        return occurance

    def count(self,obj):
        return self.search(obj).occurance
    
    def remove(self,obj):
        """ komplexity O(N)"""
        nodetoDelete = self.search(obj)
        if nodetoDelete == None:
            print(obj,"is not in the List")
        else:
            for i in range(0,len(nodetoDelete.next)):
                currentParent = self.internalSearch(obj,i)
                currentParent.next[i] = currentParent.next[i].next[i]
        
    
def readListFile(file):
    List = open(file,"r").read().split()
    #List = re.split("[\?\!]",i) for i in words
    #convert the list in my own datatype.. a bit useless but there i know the internal structure
    List = list(re.split('[\?\!,.;:-\]\[\']',i,0)[0] for i in List)
    a = SearchList(45,7)
    print(len(List))
    for element in List:
        if type(element) is str:
            a.__add__(element)
    return a   

if __name__ == "__main__":
    sysTime = time.time()
    Words = readListFile("RomeoAndJuliet.txt")
    print ("build List:", (time.time()-sysTime),"sec")
    print(len(Words))
    sysTime = time.time()
    print(Words.noOccurences())
    print ("calc noOccurences:", (time.time()-sysTime),"sec")
    sysTime = time.time()
    Words.remove("world")
    print ("remove Object:", (time.time()-sysTime),"sec")
    #print(str(Words))


#hight = int(random()*calculateHeight)+1
