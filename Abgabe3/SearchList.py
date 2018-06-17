#Aufgabe 3 von Robin Schmidt, Max Verpers, Milena Stück Python variante

import time

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
    def __init__(self):
        self.head=None
        self.len = 0
    
    def internalSearch(self, obj):
        """ returns the node that is the parent of the searched Item"""
        """ in Aufgabe2 i have to optimize the search algorythm"""
        currentPos = self.head
        while True:
            if currentPos.next == None or currentPos.next.obj>=obj:
                return currentPos
            else:
                currentPos=currentPos.next

    def __add__(self, value):
        if self.head == None:
            self.head = Node(None,value)
            self.len = self.len+1
        elif self.head.obj > value:
            newNode=Node(self.head,value)
            self.head = newNode
            self.len = self.len+1
        else:
            currentPos = self.internalSearch(value)
            
            if currentPos.next is not None and currentPos.next.obj == value:
               currentPos.next.occurance += 1
               return 
            
            newNode = Node(currentPos.next,value)
            currentPos.next = newNode
            self.len = self.len+1

    def __len__(self):
        return self.len

    def __iter__(self):
        self.IterPos = self.head
        return self
    
    def __next__(self):
        self.IterPos =self.IterPos.next
        if self.IterPos is None:
            raise StopIteration  # signals "the end"
        return self.IterPos

    def __str__(self):
        line = ""
        for obj in self:
            line = line+" "+ str(obj)

        return line

    
    def search(self,obj):
        return self.internalSearch(obj).next

    def add(self, obj):
        """ komplexity O(N)"""
        __add__(obj,prio)

    def noOccurences(self):
        """ complexity O(n)"""
        currentPos = self.head
        occurance = 0
        if currentPos is not None:
            while True:
                occurance += currentPos.occurance
                if currentPos.next is None:
                    break
                currentPos = currentPos.next
        return occurance
    
    def remove(self,obj):
        """ komplexity O(N)"""
        currentParent = self.internalSearch(obj)
        if currentParent.next.obj == obj:
            currentParent.next = currentParent.next.next
        
    
def readListFile(file):
    List = open(file,"r").read().split()
    #convert the list in my own datatype.. a bit useless but there i know the internal structure
    a = SearchList()
    for element in List:
        if type(element) is str:
            a.__add__(element)
    return a   

if __name__ == "__main__":
    sysTime = time.time()
    Words = readListFile("RomeoAndJuliet.txt")
    print ("build List:", int(time.time()-sysTime),"sec")
    print(len(Words))
    sysTime = time.time()
    print(Words.noOccurences())
    print ("calc noOccurences:", int(time.time()-sysTime),"sec")
    #print(str(Words))
