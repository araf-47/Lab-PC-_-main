Here are concise answers to your UML / Systems Analysis and Design questions:

### 3.1 What are the advantages of the traditional waterfall life cycle?

1. Simple and easy to understand.
2. Clearly defined phases (requirements, design, implementation, testing, maintenance).
3. Easy to manage because milestones and deliverables are well specified.
4. Documentation is produced at every stage.
5. Suitable for projects with stable and well-understood requirements.
6. Progress can be measured easily.

---

### 3.2 What are the disadvantages of the traditional waterfall life cycle?

1. Difficult to accommodate changing requirements.
2. Users see the system only near the end of development.
3. Errors in requirements may be discovered late.
4. High risk if requirements are misunderstood.
5. Testing occurs late in the process.
6. Long development time before any usable product is available.
7. Not suitable for complex or uncertain projects.

---

### 3.3 How are some of the disadvantages listed in your answer to Question 3.2 overcome?

They are overcome through approaches such as:

* **Prototyping:** Users can see and evaluate an early version of the system.
* **Incremental Development:** The system is delivered in small working parts.
* **Iterative Development:** Requirements and designs can be refined repeatedly.
* **Agile Methods:** Continuous user feedback allows easier adaptation to changes.

These approaches reduce risk, improve communication, and detect problems earlier.

---

### 3.4 What is prototyping?

**Prototyping** is the process of building an early working model of a system to help users and developers better understand requirements and system behavior before the final system is developed.

Benefits include:

* Better requirements understanding.
* Early user feedback.
* Reduced risk of building the wrong system.

---

### 3.5 How does prototyping differ from incremental development?

| Prototyping                                            | Incremental Development                          |
| ------------------------------------------------------ | ------------------------------------------------ |
| Creates an experimental model to clarify requirements. | Delivers parts of the final system in stages.    |
| Prototype may be discarded after use.                  | Each increment becomes part of the final system. |
| Focuses on learning and validation.                    | Focuses on delivering working functionality.     |
| Used mainly during requirements analysis.              | Used throughout development.                     |

---

### 3.6 What are the different ways of involving users in the systems development activity? What are potential problems with each of these?

| User Involvement Method | Potential Problems                                                  |
| ----------------------- | ------------------------------------------------------------------- |
| Interviews              | Users may not explain needs clearly.                                |
| Questionnaires          | Limited detail and possible misunderstandings.                      |
| Workshops/JAD Sessions  | Difficult to schedule; dominant participants may influence results. |
| Observation             | Users may behave differently when observed.                         |
| Prototyping             | Users may think the prototype is the final system.                  |
| User Testing            | Feedback may come too late to make major changes.                   |

---

### 3.7 How do 'syntactic correctness', 'consistency' and 'completeness' differ from each other?

**Syntactic Correctness**

* A model follows the rules of the modeling language (e.g., UML syntax).

**Consistency**

* Different diagrams and models do not contradict each other.

**Completeness**

* All required information and requirements are represented in the model.

Example:

* A UML class diagram may be syntactically correct.
* It is consistent if it agrees with use-case and sequence diagrams.
* It is complete if all required classes and relationships are included.

---

### 3.8 What does requirements traceability mean?

**Requirements traceability** is the ability to track each requirement throughout the development lifecycle, from its origin through design, implementation, testing, and maintenance.

Benefits:

* Ensures all requirements are implemented.
* Helps assess the impact of changes.
* Improves verification and validation.

---

### 3.9 Why is it not enough for a diagram to be syntactically correct, consistent and complete?

A diagram can be:

* **Syntactically correct** (follows UML rules),
* **Consistent** (does not conflict with other diagrams),
* **Complete** (contains all required elements),

yet still be **incorrect from a business perspective**.

It must also accurately represent the real-world requirements and stakeholder needs. A perfectly drawn UML model is useless if it describes the wrong system.

---

### 3.10 What is the purpose of a repository?

A **repository** is a central storage location for project artifacts such as:

* Requirements
* UML diagrams
* Design documents
* Source code
* Test cases
* Project metadata

Purposes:

1. Provides a single source of information.
2. Supports traceability.
3. Improves consistency among models.
4. Enables version control and collaboration.
5. Helps manage changes throughout development.

---

### Short Exam-Style Answers

**3.1:** Easy to manage, clear phases, good documentation, suitable for stable requirements.

**3.2:** Inflexible, late user feedback, late testing, costly changes, high risk of requirement errors.

**3.3:** Using prototyping, iterative, incremental, and agile approaches.

**3.4:** An early working model built to understand and validate requirements.

**3.5:** Prototyping validates requirements; incremental development delivers the final system in stages.

**3.6:** Interviews, questionnaires, workshops, observation, prototyping, testing; each has communication and participation limitations.

**3.7:** Syntactic correctness = follows UML rules; consistency = no contradictions; completeness = all required information included.

**3.8:** Ability to track requirements from origin through implementation and testing.

**3.9:** The model must also accurately represent stakeholder needs and real-world requirements.

**3.10:** A central storage facility for requirements, models, code, and project information.
