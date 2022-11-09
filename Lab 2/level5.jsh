void serveCruises(Cruise[] cruiseArr) {
    List<Loader> loaderList = new ArrayList<>();
    int numOfCruise = cruiseArr.length;

    for (int i = 0; i < numOfCruise; i++) {
        Cruise cruise = cruiseArr[i];
        int loadersNeeded = cruise.getNumOfLoadersRequired();
        while (loadersNeeded > 0) {
            if (loaderList.size() < 1) {
                Loader loaderAdded = new Loader(1, cruise);
                loaderList.add(loaderAdded);
                loadersNeeded = loadersNeeded - 1;
                System.out.println(loaderAdded);
                } else {
                for (int k = 0; k < loaderList.size(); k++) {
                    if ((loadersNeeded > 0) && (loaderList.get(k).canServe(cruise)) && (!loaderList.get(k).getCurrentCruise().equals(cruise))) {
                        Loader newLoader = loaderList.get(k).serve(cruise);
                        loaderList.set(k, newLoader);
                        loadersNeeded = loadersNeeded - 1;
                        System.out.println(loaderList.get(k));
                    }
                }
                if (loadersNeeded > 0) {
                    int size = loaderList.size();
                    int newLoadersToAdd = loadersNeeded;
                    for (int j = 0; j < newLoadersToAdd; j++) {
                        Loader loaderAdded = new Loader(size + j + 1, cruise);
                        loaderList.add(loaderAdded);
                        loadersNeeded = loadersNeeded - 1;
                        System.out.println(loaderAdded);
                        }
                    }                    
                }    
            }
        }
    }

