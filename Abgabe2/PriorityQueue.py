
class Node:
    def __init__(self,parent,next,obj):
        self.next = next
        self.parent = parent
        self.obj = obj

    def __repr__(self):
        return str(self.obj)

    def __str__(self):
        return str(self.obj)

    def __next__(self):
        return self.next

class prioQueue:
    def __init__(self):
        self.head=None
    
    def __add__(self, obj):
        
        if self.head == None:
            self.head = Node(None,obj)
        elif self.head.obj > obj:
            self.head = Node(self.head,obj)
        else:
            currentPos = self.head
            while True:
                if currentPos.next.obj<obj or currentPos.next == None:
                    currentPos.next = Node(currentPos.next,obj)
                    break
                else:
                    currentPos=currentPos.next
    
    def insert(self, obj):
        """ komplexity O(N)"""
        __add__(obj)
    
    def min(self):
        """ komplexity O(1)"""
        return self.head

    def getMin(self):
        """ komplexity O(1)"""
        oldhead = self.head
        self.head = head.next
        return oldhead
    
    def replaceMin(self,obj):
        """bad function. its going to destroy the queue add algorythm, and it makes no sence"""
        self.head = Node(self.head,obj)

def findPair(x,NumberList):
    StartValue = x//2
    print(StartValue)

    a = None
    b = None
    loops = 0
    for number in NumberList:
        loops +=1
        if number.obj>=StartValue: 
            a = number
            b = number
            break
        
    while a.obj+b.obj!=x:
        loops +=1
        if a.obj+b.obj > x:
            if a.parent is None:
                return None
            a = a.parent
            
        elif (a.obj + b.obj)< x:
            if b.next is None:
                return None
            b = b.next

    print(a," + ",b," = ",x," with ",loops," loops")
    return (a," + ",b," = ",x)
        



def readListFile(file):
    List = open(file,"r").read().split()
    #print(List)
    #convert the list in my own datatype.. a bit useless but there i know the internal structure
    a = myList()
    for element in List:
        #print(element)
        #print (type(element))
        if type(element) is str:
            a.add(int(element))
            #print(int(element))
    
    return a

class myList:
    def __init__(self):
        self.head = None
        self.lastElement = None
        self.IterPos = self.head

    def add(self, obj):
        if self.head == None:
            self.head = Node(None,None,obj)
            self.lastElement = self.head
        else:
            self.lastElement.next =Node(self.lastElement,None,obj)
            self.lastElement = self.lastElement.next
    def __str__(self):
        return "list"

    def __iter__(self):
        self.IterPos = self.head
        return self
    def __next__(self):
        self.IterPos =self.IterPos.next
        if self.IterPos is None:
            raise StopIteration  # signals "the end"
        return self.IterPos


if __name__ == "__main__":
    Numbers = readListFile("L.dat")

    x1=5260
    x2=7136314
    x3 = 9785000

    print("check:",x1," result: ",findPair(x1,Numbers))
    print("check:",x2," result: ",findPair(x2,Numbers))
    print("check:",x3," result: ",findPair(x3,Numbers))

    
                
                
