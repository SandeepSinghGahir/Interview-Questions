def getNumberOfRefills(plantsArray,capacity):
    cap1 = capacity[0]
    cap2 = capacity[1]
    refills = 0
    currentCapacity1,currentCapacity2 = 0,0
    front = 0
    rear = len(plantsArray)-1
    while front < rear:
        if plantsArray[front] > currentCapacity1:
            refills+=1
            currentCapacity1 = cap1 - plantsArray[front]
        else : 
            currentCapacity1 = currentCapacity1 - plantsArray[front]
        if plantsArray[rear] > currentCapacity2:
            refills+=1
            currentCapacity2 = cap2 - plantsArray[rear]
        else:
            currentCapacity2 = currentCapacity2 - plantsArray[rear]
        front+=1
        rear-=1

    if front==rear and currentCapacity1 + currentCapacity2 < plantsArray[front]:
        refills+=1
        return refills
    return refills    

plantsArray = [2,2,2,2,2]
capacity= [2,2]
print(getNumberOfRefills(plantsArray,capacity))
